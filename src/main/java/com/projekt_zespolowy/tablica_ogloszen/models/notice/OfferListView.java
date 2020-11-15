package com.projekt_zespolowy.tablica_ogloszen.models.notice;

import com.google.common.collect.Lists;
import com.projekt_zespolowy.tablica_ogloszen.models.image.Image;
import com.projekt_zespolowy.tablica_ogloszen.models.image.ImageView;
import com.projekt_zespolowy.tablica_ogloszen.models.price.PriceView;
import com.projekt_zespolowy.tablica_ogloszen.models.user.UserView;
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
  private UserView vendor = new UserView();
  private String title;
  private String text;
  private PriceView price = new PriceView();
  private List<ImageView> images = Lists.newArrayList();
  private LocalDateTime creationDate;

}
