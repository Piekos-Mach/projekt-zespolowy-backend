package com.projekt_zespolowy.tablica_ogloszen.models.user;

public class UpdateUserCmd {

  private Long id;
  private String name;
  private String newPassword;
  private String oldPassword;

  public UpdateUserCmd() {
  }

  public UpdateUserCmd(Long id, String name, String newPassword, String oldPassword) {
    this.id = id;
    this.name = name;
    this.newPassword = newPassword;
    this.oldPassword = oldPassword;
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

  public String getNewPassword() {
    return newPassword;
  }

  public void setNewPassword(String newPassword) {
    this.newPassword = newPassword;
  }

  public String getOldPassword() {
    return oldPassword;
  }

  public void setOldPassword(String oldPassword) {
    this.oldPassword = oldPassword;
  }

}
