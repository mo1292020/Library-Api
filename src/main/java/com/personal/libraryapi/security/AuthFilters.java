package com.personal.libraryapi.security;

import com.personal.libraryapi.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log4j2
public class AuthFilters extends OncePerRequestFilter {

    @Autowired
    private com.personal.libraryapi.security.JwtTokenUtils jwtTokenUtils;
    @Autowired
    private UserService userService;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String jwtTokenHeader = request.getHeader("Authorization");
//        log.info("Path is >> " + request.getRequestURL());
//        log.info("jwtTokenHeader is : " + jwtTokenHeader);
        final SecurityContext securityContext = SecurityContextHolder.getContext();
          if (jwtTokenHeader != null && securityContext.getAuthentication() == null) {
            String jwtToken = jwtTokenHeader.substring("Bearer ".length());
            if (jwtTokenUtils.validateToken(jwtToken, request)) {
                String username = jwtTokenUtils.getUserNameFromToken(jwtToken);
                if (username != null) {
                    com.personal.libraryapi.security.APPUserDetail userDetails = (com.personal.libraryapi.security.APPUserDetail) userService.loadUserByUsername(username);
                    if (jwtTokenUtils.isTokenValid(jwtToken, userDetails)) {
                        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                                userDetails, null, userDetails.getAuthorities());
                        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                        SecurityContextHolder.getContext().setAuthentication(authentication);
                    }
                }
            }
        }
        filterChain.doFilter(request, response);
    }

    protected boolean isSwaggerUrl(String url) {
        if (url.contains("swagger") || url.contains("api-docs") || url.contains("configuration/ui") || url.contains("webjars/")
                || url.contains("swagger-resources") || url.contains("configuration/security") || url.contains("actuator")) {
            return true;
        } else {
            return false;
        }

    }


}
