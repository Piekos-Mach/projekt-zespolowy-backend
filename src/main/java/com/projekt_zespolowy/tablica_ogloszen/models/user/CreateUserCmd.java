package com.projekt_zespolowy.tablica_ogloszen.models.user;

import com.projekt_zespolowy.tablica_ogloszen.models.user.UserType.USER_TYPE;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserCmd {

  private String name;
  private String password;
  private Long type = USER_TYPE.CUSTOMER.getId();

}
