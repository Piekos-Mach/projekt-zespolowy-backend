package com.projekt_zespolowy.tablica_ogloszen.models.basic;

public class BasicSelect {

  private Long id;
  private Long name;

  public BasicSelect(Long id, Long name) {
    this.id = id;
    this.name = name;
  }

  public BasicSelect() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getName() {
    return name;
  }

  public void setName(Long name) {
    this.name = name;
  }

}
