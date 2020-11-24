package com.projekt_zespolowy.tablica_ogloszen.models.image;

import com.projekt_zespolowy.tablica_ogloszen.validation.SecondLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateImageCmd {

    @NotNull(message = "{content.notNull}", groups = SecondLevel.class)
    private String content;

}
