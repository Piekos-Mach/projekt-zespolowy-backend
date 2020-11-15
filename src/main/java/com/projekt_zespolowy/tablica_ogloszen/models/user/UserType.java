package com.projekt_zespolowy.tablica_ogloszen.models.user;

import java.util.HashMap;
import java.util.Map;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "dictionary_user_type")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserType {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "user_type_id")
  private Long id;

  @Column(name = "name")
  private String name;

  public enum USER_TYPE {
    CUSTOMER(1L),
    GUEST(2L),
    ADMIN(4L);

    private static final Map<Long, USER_TYPE> BY_ID = new HashMap<>();

    static {
      for (USER_TYPE e : values()) {
        BY_ID.put(e.id, e);
      }
    }

    private Long id;

    USER_TYPE(Long id) {
      this.id = id;
    }

    public static USER_TYPE idOf(Long id) {
      return BY_ID.get(id);
    }

    public Long getId() {
      return this.id;
    }

    public UserType toUserType() {
      return new UserType(this.id, this.name());
    }

  }

}
