package com.projekt_zespolowy.tablica_ogloszen.models.user;

import com.projekt_zespolowy.tablica_ogloszen.models.user.UserType.USER_TYPE;
import com.projekt_zespolowy.tablica_ogloszen.validation.SecondLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserCmd {

    @NotBlank(message = "{name.notBlank}", groups = SecondLevel.class)
    private String name;

    @NotBlank(message = "{password.notBlank}", groups = SecondLevel.class)
    private String password;

    @NotBlank(message = "{mail.notBlank}", groups = SecondLevel.class)
    private String mail;

    private UserType type = USER_TYPE.CUSTOMER.toUserType();

}
