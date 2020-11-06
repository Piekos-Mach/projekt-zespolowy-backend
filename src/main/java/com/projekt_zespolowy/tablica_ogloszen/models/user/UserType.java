package com.projekt_zespolowy.tablica_ogloszen.models.user;

import java.util.HashMap;
import java.util.Map;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dictionary_user_type")
public class UserType {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "user_status_id")
  private Long id;

  @Column(name = "name")
  private String name;

  public enum USER_STATUS {
    ADMIN(1L),
    USER(2L);

    private Long id;
    private static final Map<Long, USER_STATUS> BY_ID = new HashMap<>();

    static {
      for (USER_STATUS e : values()) {
        BY_ID.put(e.id, e);
      }
    }

    USER_STATUS(Long id) {
      this.id = id;
    }

    public Long getId() {
      return this.id;
    }

    public static USER_STATUS idOf(Long id) {
      return BY_ID.get(id);
    }

    public UserType toUserStatus() {
      return new UserType(this.id, this.name());
    }

  }

  public UserType() {
  }

  public UserType(Long id, String name) {
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
