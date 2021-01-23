package com.projekt_zespolowy.tablica_ogloszen.config.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.projekt_zespolowy.tablica_ogloszen.models.user.User;
import java.io.IOException;
import java.util.Date;
import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import static com.projekt_zespolowy.tablica_ogloszen.config.security.SecurityConstants.*;

@Slf4j
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

  private final AuthenticationManager authenticationManager;
  private final ObjectMapper objectMapper;

  public JwtAuthenticationFilter(
      AuthenticationManager authenticationManager,
      ObjectMapper objectMapper) {

    this.authenticationManager = authenticationManager;
    this.objectMapper = objectMapper;
    setFilterProcessesUrl(LOG_IN_URL);
  }

  @Override
  public Authentication attemptAuthentication(
      HttpServletRequest request,
      HttpServletResponse response) {

    try {
      LoginCmd cmd = this.objectMapper.readValue(request.getInputStream(), LoginCmd.class);
      UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
          new UsernamePasswordAuthenticationToken(cmd.getUsername(), cmd.getPassword());
      Authentication authentication =
          this.authenticationManager.authenticate(usernamePasswordAuthenticationToken);

      return authentication;
    } catch (IOException ex) {
      throw new RuntimeException(ex);
    }
  }

  @Override
  protected void successfulAuthentication(
      HttpServletRequest request,
      HttpServletResponse response,
      FilterChain chain,
      Authentication authResult) {

    String user = ((User) authResult.getPrincipal()).getName();
    Date expirationDate = new Date(System.currentTimeMillis() + EXPIRATION_TIME);
    Algorithm sign = Algorithm.HMAC512(SECRET.getBytes());
    String token =
        JWT.create()
           .withSubject(user)
           .withExpiresAt(expirationDate)
           .sign(sign);

    response.addHeader(HEADER_STRING, TOKEN_PREFIX + token);
    response.addHeader("userId", String.valueOf(((User) authResult.getPrincipal()).getId()));
  }

}
