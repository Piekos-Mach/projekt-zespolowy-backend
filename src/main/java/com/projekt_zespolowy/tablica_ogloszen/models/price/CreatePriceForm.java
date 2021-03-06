package com.projekt_zespolowy.tablica_ogloszen.models.price;

import com.projekt_zespolowy.tablica_ogloszen.models.price.Currency.CURRENCY;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePriceForm {

  private BigDecimal value = BigDecimal.ZERO;
  private Long currency = CURRENCY.PLN.getId();

}
