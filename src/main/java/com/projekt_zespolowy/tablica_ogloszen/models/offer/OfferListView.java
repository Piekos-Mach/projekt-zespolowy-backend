package com.projekt_zespolowy.tablica_ogloszen.models.offer;

import com.google.common.collect.Lists;
import com.projekt_zespolowy.tablica_ogloszen.models.basic.BasicView;
import com.projekt_zespolowy.tablica_ogloszen.models.image.ImageView;
import com.projekt_zespolowy.tablica_ogloszen.models.price.PriceView;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OfferListView {

  private Long id;
  private BasicView owner = new BasicView();
  private String title;
  private String text;
  private PriceView price = new PriceView();
  private List<ImageView> images = Lists.newArrayList();
  private LocalDateTime creationDate;

}
