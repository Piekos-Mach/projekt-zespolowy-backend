package com.projekt_zespolowy.tablica_ogloszen.models.user;

import com.projekt_zespolowy.tablica_ogloszen.models.basic.BasicView;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class UserView {

    private Long id;
    private String name;
    private BasicView type = new BasicView();
    private String mail;

}
