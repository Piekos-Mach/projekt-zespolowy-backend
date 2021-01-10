package com.projekt_zespolowy.tablica_ogloszen.config.security;

import static com.projekt_zespolowy.tablica_ogloszen.config.security.SecurityConstants.HEADER_STRING;
import static com.projekt_zespolowy.tablica_ogloszen.config.security.SecurityConstants.SECRET;
import static com.projekt_zespolowy.tablica_ogloszen.config.security.SecurityConstants.TOKEN_PREFIX;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Slf4j
public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

  private final UserDetailsService userDetailsService;

  public JwtAuthorizationFilter(
      AuthenticationManager authenticationManager,
      UserDetailsService userDetailsService) {

    super(authenticationManager);
    this.userDetailsService = userDetailsService;
  }

  @Override
  protected void doFilterInternal(
      HttpServletRequest request,
      HttpServletResponse response,
      FilterChain chain)
      throws IOException, ServletException {

    String header = request.getHeader(HEADER_STRING);
    if (header == null || !header.startsWith(TOKEN_PREFIX)) {
      chain.doFilter(request, response);
      return;
    }
    UsernamePasswordAuthenticationToken authentication = getAuthentication(request);
    SecurityContextHolder.getContext().setAuthentication(authentication);
    chain.doFilter(request, response);
  }

  private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {

    String token = request.getHeader(HEADER_STRING);
    if (token != null) {
      Algorithm algorithm = Algorithm.HMAC512(SECRET.getBytes());
      String tokenWithoutPrefix = token.replace(TOKEN_PREFIX, "");
      String userName =
          JWT.require(algorithm)
             .build()
             .verify(tokenWithoutPrefix)
             .getSubject();

      if (userName != null) {
        UserDetails user = userDetailsService.loadUserByUsername(userName);
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
            new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
        return usernamePasswordAuthenticationToken;
      }
      return null;
    }
    return null;
  }

}
