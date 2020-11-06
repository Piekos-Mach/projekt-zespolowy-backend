package com.projekt_zespolowy.tablica_ogloszen.models.notice;

import com.google.common.collect.Lists;
import com.projekt_zespolowy.tablica_ogloszen.models.price.UpdatePriceForm;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateNoticeForm {

  private Long id;
  private Long vendor;
  private String title;
  private String text;
  private UpdatePriceForm price;
  private List<String> images = Lists.newArrayList();

}
