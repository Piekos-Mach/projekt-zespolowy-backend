package com.projekt_zespolowy.tablica_ogloszen.models.price;

import java.math.BigDecimal;
import javax.persistence.Embeddable;

@Embeddable
public class Price {

  private BigDecimal value;
  private Currency currency;

}
