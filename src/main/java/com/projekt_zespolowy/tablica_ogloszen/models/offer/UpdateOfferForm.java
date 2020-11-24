package com.projekt_zespolowy.tablica_ogloszen.models.offer;

import com.google.common.collect.Lists;
import com.projekt_zespolowy.tablica_ogloszen.models.image.CreateImageForm;
import com.projekt_zespolowy.tablica_ogloszen.models.price.UpdatePriceForm;

import java.util.List;

import com.projekt_zespolowy.tablica_ogloszen.validation.FirstLevel;
import com.projekt_zespolowy.tablica_ogloszen.validation.SecondLevel;
import com.projekt_zespolowy.tablica_ogloszen.validation.offer.OfferExists;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateOfferForm {

    @NotNull(message = "{id.notNull}", groups = FirstLevel.class)
    @Positive(message = "{id.positive}", groups = FirstLevel.class)
    @OfferExists(groups = SecondLevel.class)
    private Long id;

    @NotBlank(message = "{title.notBlank}", groups = SecondLevel.class)
    private String title;

    private String text;

    private UpdatePriceForm price = new UpdatePriceForm();

    @NotNull(message = "{images.notNull}", groups = SecondLevel.class)
    private List<CreateImageForm> images = Lists.newArrayList();

}
