package com.projekt_zespolowy.tablica_ogloszen.models.offer;

import com.google.common.collect.Lists;
import com.projekt_zespolowy.tablica_ogloszen.models.image.CreateImageCmd;
import com.projekt_zespolowy.tablica_ogloszen.models.offer.OfferStatus.OFFER_STATUS;
import com.projekt_zespolowy.tablica_ogloszen.models.price.CreatePriceCmd;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOfferCmd {

  private Long owner;
  private String title;
  private String text;
  private CreatePriceCmd price;
  private List<CreateImageCmd> images = Lists.newArrayList();
  private LocalDateTime creationDate = LocalDateTime.now();
  private OfferStatus status = OFFER_STATUS.ACTIVE.toOfferStatus();

}
