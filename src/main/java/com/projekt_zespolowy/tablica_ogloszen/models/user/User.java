package com.projekt_zespolowy.tablica_ogloszen.models.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "user_id")
  private Long id;

  @ManyToOne
  @JoinColumn(name = "user_type_id")
  private UserType type;

  @Column(name = "name")
  private String name;

  @Column(name = "password")
  private String password;

}
