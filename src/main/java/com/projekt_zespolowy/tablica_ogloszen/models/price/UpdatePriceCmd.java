package com.projekt_zespolowy.tablica_ogloszen.models.price;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePriceCmd {

  private BigDecimal value = BigDecimal.ZERO;
  private Long currency;

}
