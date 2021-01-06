package com.projekt_zespolowy.tablica_ogloszen.models.offer;

import com.projekt_zespolowy.tablica_ogloszen.models.basic.BasicView;
import com.projekt_zespolowy.tablica_ogloszen.models.image.ImageView;
import com.projekt_zespolowy.tablica_ogloszen.models.price.PriceView;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OfferPageViewL {

    private Long id;
    private BasicView owner = new BasicView();
    private String title;
    private String text;
    private PriceView price = new PriceView();
    private Long miniature;
    private LocalDateTime creationDate;

    public OfferPageViewL(
            Long id,
            BasicView owner,
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