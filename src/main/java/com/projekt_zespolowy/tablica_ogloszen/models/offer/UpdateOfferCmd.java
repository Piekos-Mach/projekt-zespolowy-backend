package com.projekt_zespolowy.tablica_ogloszen.models.offer;

import com.google.common.collect.Lists;
import com.projekt_zespolowy.tablica_ogloszen.models.image.CreateImageCmd;
import com.projekt_zespolowy.tablica_ogloszen.models.price.UpdatePriceCmd;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateOfferCmd {

  private Long id;
  private String title;
  private String text;
  private UpdatePriceCmd price = new UpdatePriceCmd();
  private List<CreateImageCmd> images = Lists.newArrayList();

}
