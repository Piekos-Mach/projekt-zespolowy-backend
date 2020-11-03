package com.projekt_zespolowy.tablica_ogloszen.models.user;

import com.projekt_zespolowy.tablica_ogloszen.models.user.UserType.USER_STATUS;

public class CreateUserCmd {

  private String name;
  private String password;
  private Long type = USER_STATUS.USER.getId();

  public CreateUserCmd() {
  }

  public CreateUserCmd(String name, String password, Long type) {
    this.name = name;
    this.password = password;
    this.type = type;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Long getType() {
    return type;
  }

  public void setType(Long type) {
    this.type = type;
  }

}
