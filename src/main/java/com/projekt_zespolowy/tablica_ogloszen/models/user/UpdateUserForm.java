package com.projekt_zespolowy.tablica_ogloszen.models.user;

public class UpdateUserForm {

  private Long id;
  private String name;

  public UpdateUserForm() {
  }

  public UpdateUserForm(Long id, String name) {
    this.id = id;
    this.name = name;
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

}
