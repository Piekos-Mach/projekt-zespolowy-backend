package com.projekt_zespolowy.tablica_ogloszen.models.basic;

public class BasicView {

  private Long id;
  private String name;

  public BasicView() {
  }

  public BasicView(Long id, String name) {
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
