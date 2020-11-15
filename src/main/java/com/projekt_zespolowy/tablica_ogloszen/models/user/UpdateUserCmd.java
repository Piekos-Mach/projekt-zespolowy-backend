package com.projekt_zespolowy.tablica_ogloszen.models.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserCmd {

  private Long id;
  private String name;
  private String mail;
  private String newPassword;
  private String oldPassword;

}
