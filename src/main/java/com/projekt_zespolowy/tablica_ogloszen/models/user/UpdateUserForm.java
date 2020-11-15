package com.projekt_zespolowy.tablica_ogloszen.models.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateUserForm {

  private Long id;
  private String name;

}
