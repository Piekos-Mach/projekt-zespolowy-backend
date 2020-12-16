package com.projekt_zespolowy.tablica_ogloszen.config.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginCmd {

  private String username;
  private String password;

}