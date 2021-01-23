package com.projekt_zespolowy.tablica_ogloszen.config.security;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "role")
@JsonIgnoreProperties({"authority"})
public class Role implements GrantedAuthority {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "role_id")
  private Long id;

  @Column(name = "name")
  @NotNull
  private String name;

  @Override
  public String getAuthority() {

    return name;
  }

  public enum ROLE {
    USER(1L),
    GUEST(2L),
    ADMIN(4L);

    private static final Map<Long, Role.ROLE> BY_ID = new HashMap<>();

    static {
      for (Role.ROLE e : values()) {
        BY_ID.put(e.id, e);
      }
    }

    private Long id;

    ROLE(Long id) {
      this.id = id;
    }

    public static Role.ROLE idOf(Long id) {
      return BY_ID.get(id);
    }

    public Long getId() {
      return this.id;
    }

    public Role toRole() {
      return new Role(this.id, this.name());
    }

  }

}
