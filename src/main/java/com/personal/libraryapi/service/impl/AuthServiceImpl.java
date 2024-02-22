package com.personal.libraryapi.service.impl;

import com.personal.libraryapi.dto.AccessTokenDto;
import com.personal.libraryapi.dto.JwtResponseDto;
import com.personal.libraryapi.entity.TokenInfoEntity;
import com.personal.libraryapi.entity.UsersEntity;
import com.personal.libraryapi.mapper.TokenInfoMapper;
import com.personal.libraryapi.security.APPUserDetail;
import com.personal.libraryapi.security.JwtTokenUtils;
import com.personal.libraryapi.service.AuthService;
import com.personal.libraryapi.service.TokenInfoService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Optional;
import java.util.UUID;

@Log4j2
@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthenticationManager authManager;
    @Autowired
    private  HttpServletRequest httpRequest;
    @Autowired
    private  TokenInfoService tokenInfoService;
    @Autowired
    private  TokenInfoMapper tokenInfoMapper;
    @Autowired
    private  JwtTokenUtils jwtTokenUtils;
    @Override
    public JwtResponseDto login(String userName, String password) {
        Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(userName,password));
        log.debug("valid user details credentials");
        APPUserDetail appUserDetail = (APPUserDetail) authentication.getPrincipal();
        SecurityContextHolder.getContext().setAuthentication(authentication);
        log.debug("SecurityContextHolder updated, [userName = {}]",userName);

        TokenInfoEntity tokenInfoEntity = createLoginToken(userName,appUserDetail.getId());

        return JwtResponseDto.builder()
                .accessToken(tokenInfoEntity.getAccessToken())
                .refreshToken(tokenInfoEntity.getRefreshToken()).build();
    }

    public TokenInfoEntity createLoginToken(String userName, Long userId) {
        String userAgent = httpRequest.getHeader(HttpHeaders.USER_AGENT);
        InetAddress ip = null;
        try {
            ip = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String accessTokenId = UUID.randomUUID().toString();
        String accessToken = JwtTokenUtils.generateToken(userName, accessTokenId, false);
        log.info("Access token created. [tokenId={}]", accessTokenId);

        String refreshTokenId = UUID.randomUUID().toString();
        String refreshToken = JwtTokenUtils.generateToken(userName, refreshTokenId, true);
        log.info("Refresh token created. [tokenId={}]", refreshToken);

        TokenInfoEntity tokenInfoEntity = new TokenInfoEntity(accessToken, refreshToken);
        tokenInfoEntity.setUsersEntity(new UsersEntity(userId));
        tokenInfoEntity.setUserAgentText(userAgent);
        tokenInfoEntity.setLocalIpAddress(ip.getHostAddress()); //server address
        tokenInfoEntity.setRemoteIpAddress(httpRequest.getRemoteAddr()); // client address
        return tokenInfoService.save(tokenInfoEntity);
    }


    @Override
    public AccessTokenDto refreshAccessToken(String refreshToken) {
        refreshToken = refreshToken.substring("Bearer ".length());
        if (jwtTokenUtils.isTokenExpired(refreshToken)) {
            return null;
        }
        String userName = jwtTokenUtils.getUserNameFromToken(refreshToken);
        Optional<TokenInfoEntity> refresh = tokenInfoService.findByRefreshToken(refreshToken);
        if (!refresh.isPresent()) {
            return null;
        }

        return new AccessTokenDto(JwtTokenUtils.generateToken(userName, UUID.randomUUID().toString(), false));

    }

    @Override
    public boolean logout(String refreshToken){
        refreshToken = refreshToken.substring("Bearer ".length());
        Optional<TokenInfoEntity> tokenInfoEntity = tokenInfoService.findByRefreshToken(refreshToken);
        if(tokenInfoEntity.isPresent()){
            tokenInfoService.deleteById(tokenInfoEntity.get().getId());
            return true;
        }
        return false;
    }


}
