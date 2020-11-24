package com.projekt_zespolowy.tablica_ogloszen.models.offer;

import com.projekt_zespolowy.tablica_ogloszen.validation.FirstLevel;
import com.projekt_zespolowy.tablica_ogloszen.validation.SecondLevel;
import com.projekt_zespolowy.tablica_ogloszen.validation.offer.OfferExists;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteOfferCmd {

    @NotNull(message = "{id.notNull}", groups = FirstLevel.class)
    @Positive(message = "{id.positive}", groups = FirstLevel.class)
    @OfferExists(groups = SecondLevel.class)
    private Long id;

}
