package com.projekt_zespolowy.tablica_ogloszen.models.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserForm {

  private String name = "";
  private String password = "";
  private String mail = "";

}
