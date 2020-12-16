package com.projekt_zespolowy.tablica_ogloszen.config.security;

import com.projekt_zespolowy.tablica_ogloszen.models.user.User;
import com.projekt_zespolowy.tablica_ogloszen.repositories.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AppUserDetailService implements UserDetailsService {

  private final UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    User user = userRepository.findByName(username);

    if (user == null) {
      throw new UsernameNotFoundException(String.format("The username %s doesn't exist", username));
    }
    return user;
  }

}
