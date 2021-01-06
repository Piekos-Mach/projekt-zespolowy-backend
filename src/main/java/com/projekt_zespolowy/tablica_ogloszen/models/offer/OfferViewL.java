package com.projekt_zespolowy.tablica_ogloszen.models.offer;

import com.google.common.collect.Lists;
import com.projekt_zespolowy.tablica_ogloszen.models.price.PriceView;
import com.projekt_zespolowy.tablica_ogloszen.models.user.UserView;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OfferViewL {

    private Long id;
    private UserView owner = new UserView();
    private String title;
    private String text;
    private PriceView price = new PriceView();
    private List<Long> images = Lists.newArrayList();
    private LocalDateTime creationDate;

    public OfferViewL(
            Long id,
            UserView owner,
            String title,
            String text,
            PriceView price,
            LocalDateTime creationDate) {

        this.id = id;
        this.owner = owner;
        this.title = title;
        this.text = text;
        this.price = price;
        this.creationDate = creationDate;
    }

}