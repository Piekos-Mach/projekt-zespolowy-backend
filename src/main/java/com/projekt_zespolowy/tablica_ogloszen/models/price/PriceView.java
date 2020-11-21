package com.projekt_zespolowy.tablica_ogloszen.models.price;

import com.projekt_zespolowy.tablica_ogloszen.models.basic.BasicView;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PriceView {

  private BigDecimal value = BigDecimal.ZERO;
  private BasicView currency = new BasicView();

}
