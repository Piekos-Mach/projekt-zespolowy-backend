package com.projekt_zespolowy.tablica_ogloszen.models.user;

import com.projekt_zespolowy.tablica_ogloszen.validation.FirstLevel;
import com.projekt_zespolowy.tablica_ogloszen.validation.SecondLevel;
import com.projekt_zespolowy.tablica_ogloszen.validation.user.UserExists;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateUserForm {

  @NotNull(message = "{id.notNull}", groups = FirstLevel.class)
  @Positive(message = "{id.positive}", groups = FirstLevel.class)
  @UserExists(groups = SecondLevel.class)
  private Long id;

  @NotBlank(message = "{name.notBlank}", groups = SecondLevel.class)
  private String name;

  @NotBlank(message = "{mail.notBlank}", groups = SecondLevel.class)
  private String mail;

  @NotBlank(message = "{password.notBlank}", groups = SecondLevel.class)
  private String newPassword;

  @NotBlank(message = "{password.notBlank}", groups = SecondLevel.class)
  private String oldPassword;


}
