package com.personal.bankapidefault.security;

import io.jsonwebtoken.*;

import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.DecodingException;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.crypto.SecretKey;
import javax.servlet.http.HttpServletRequest;
import java.security.Key;
import java.util.Calendar;
import java.util.Date;


@Log4j2
@Component
public class JwtTokenUtils {
    private static String TOKEN_SECRET;
    private static Long ACCESS_TOKEN_VALIDITY;
    private static Long REFRESH_TOKEN_VALIDITY;



    public JwtTokenUtils(@Value("${auth.secret}") String secret, @Value("${auth.access.expiration}") Long accessValidity
            , @Value("${auth.refresh.expiration}") Long refreshValidity) {
        Assert.notNull(accessValidity, "Validity must not be null");
        Assert.hasText(secret, "Validity must not be null or empty");

        TOKEN_SECRET = secret;
        ACCESS_TOKEN_VALIDITY = accessValidity;
        REFRESH_TOKEN_VALIDITY = refreshValidity ;
    }

    public static String generateToken(final String userName, final String tokenId , boolean isRefresh) {
        return Jwts.builder()
                .setId(tokenId)
                .setSubject(userName)
                .setIssuedAt(new Date())
                .setIssuer("app-Service")
                .setExpiration(calcTokenExpirationDate(isRefresh))
                .claim("created", Calendar.getInstance().getTime())
                .signWith(SignatureAlgorithm.HS512,getSignInKey()).compact();
    }


    private static Date calcTokenExpirationDate(boolean isRefresh) {
        return new Date(System.currentTimeMillis() + (isRefresh ? REFRESH_TOKEN_VALIDITY : ACCESS_TOKEN_VALIDITY) * 1000);
    }

    public String getUserNameFromToken(String token) {
        Claims claims = getClaims(token);
        return claims.getSubject();
    }

    public String getTokenIdFromToken(String token) {
        return getClaims(token).getId();
    }

    public boolean isTokenValid(String token, APPUserDetail userDetails) {
//        log.info("isTokenExpired >>> " + isTokenExpired(token));
        String username = getUserNameFromToken(token);
//        log.info("username from token >>> " + username);
//        log.info("userDetails.getUsername >>> " + userDetails.getUsername());
//        log.info("username =  >>> userDetails.getUsername >>> " + username.equals(userDetails.getUsername()));
        boolean isUserNameEqual = username.equalsIgnoreCase(userDetails.getUsername()) ;
        return (isUserNameEqual && !isTokenExpired(token));
    }

    public boolean isTokenExpired(String token) {
        Date expiration = getClaims(token).getExpiration();
        return expiration.before(new Date());
    }

    private Claims getClaims(String token) {
        return Jwts.parserBuilder().setSigningKey(getSignInKey()).build().parseClaimsJws(token).getBody();
    }


    public boolean validateToken(String token , HttpServletRequest httpServletRequest){

        try {
            Jwts.parserBuilder().setSigningKey(getSignInKey()).build().parseClaimsJws(token);
            return true;
        }catch (SignatureException ex){
            log.info("Invalid JWT Signature");
            //  throw new SecurityException("Invalid JWT Signature");
        }catch (MalformedJwtException ex){
            log.info("Invalid JWT token");
            httpServletRequest.setAttribute("expired",ex.getMessage());
            //  throw new SecurityException("Invalid JWT token");
        }catch (ExpiredJwtException ex){
            log.info("Expired JWT token");
            httpServletRequest.setAttribute("expired",ex.getMessage());
            //  throw new SecurityException("security.token_expired");
        }catch (UnsupportedJwtException ex){
            log.info("Unsupported JWT exception");
            //   throw new SecurityException("Unsupported JWT exception");
        }catch (IllegalArgumentException ex){
            log.info("Jwt claims string is empty");
            //   throw new SecurityException("Jwt claims string is empty");
        }
        return false;
    }

    private static Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(TOKEN_SECRET);
        return Keys.hmacShaKeyFor(keyBytes);
    }

}
