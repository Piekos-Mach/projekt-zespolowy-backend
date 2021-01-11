package com.projekt_zespolowy.tablica_ogloszen.config.security;

import static com.projekt_zespolowy.tablica_ogloszen.config.security.SecurityConstants.SIGN_UP_URL;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  private final UserDetailsService userDetailsService;
  private final ObjectMapper objectMapper;

  @Override
  public void configure(AuthenticationManagerBuilder auth) throws Exception {

    auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
  }

  @Bean
  public PasswordEncoder passwordEncoder() {

    return new BCryptPasswordEncoder(10);
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {

    // TODO: permit all na security
    http.cors()
        .and()
        .csrf()
        .disable()
        .authorizeRequests()
        .anyRequest()
        .permitAll()
        .and()
        .addFilter(new JwtAuthenticationFilter(authenticationManager(), objectMapper))
        .addFilter(new JwtAuthorizationFilter(authenticationManager(), userDetailsService))
        // this disables session creation on Spring Security
        .sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

    // TODO: podstawowe security oparte o token JWT
//    http.cors()
//        .and()
//        .csrf()
//        .disable()
//        .authorizeRequests()
//        .antMatchers(HttpMethod.POST, SIGN_UP_URL)
//        .permitAll()
//        .anyRequest()
//        .authenticated()
//        .and()
//        .addFilter(new JwtAuthenticationFilter(authenticationManager(), objectMapper))
//        .addFilter(new JwtAuthorizationFilter(authenticationManager(), userDetailsService))
//        // this disables session creation on Spring Security
//        .sessionManagement()
//        .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
  }

  @Bean
  public CorsConfigurationSource corsConfigurationSource() {

    final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    CorsConfiguration corsConfiguration = new CorsConfiguration().applyPermitDefaultValues();
    corsConfiguration.addAllowedMethod(HttpMethod.PUT);
    source.registerCorsConfiguration("/**", corsConfiguration);

    return source;
  }

}