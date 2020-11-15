package com.projekt_zespolowy.tablica_ogloszen.models.user;

import com.projekt_zespolowy.tablica_ogloszen.models.basic.BasicView;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserView {

  private Long id;
  private String name;
  private BasicView type;
  private String mail;

}
