package com.projekt_zespolowy.tablica_ogloszen.models.offer;

import com.google.common.collect.Lists;
import com.projekt_zespolowy.tablica_ogloszen.models.price.UpdatePriceForm;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateOfferForm {

  private Long id;
  private Long owner;
  private String title;
  private String text;
  private UpdatePriceForm price = new UpdatePriceForm();
  private List<String> images = Lists.newArrayList();

}
