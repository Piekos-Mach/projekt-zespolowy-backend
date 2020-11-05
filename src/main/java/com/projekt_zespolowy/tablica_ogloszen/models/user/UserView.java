package com.projekt_zespolowy.tablica_ogloszen.models.user;

import com.projekt_zespolowy.tablica_ogloszen.models.basic.BasicView;

public class UserView {

  private Long id;
  private String name;
  private BasicView type;

  public UserView() {
  }

  public UserView(Long id, String name,
      BasicView type) {
    this.id = id;
    this.name = name;
    this.type = type;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public BasicView getType() {
    return type;
  }

  public void setType(BasicView type) {
    this.type = type;
  }

}
