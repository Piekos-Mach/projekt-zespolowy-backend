package com.projekt_zespolowy.tablica_ogloszen.models.price;

import com.projekt_zespolowy.tablica_ogloszen.models.basic.BasicView;
import java.math.BigDecimal;

public class PriceView {

  private BigDecimal value;
  private BasicView currency;

  public PriceView() {
  }

  public PriceView(BigDecimal value,
      BasicView currency) {
    this.value = value;
    this.currency = currency;
  }

  public BigDecimal getValue() {
    return value;
  }

  public void setValue(BigDecimal value) {
    this.value = value;
  }

  public BasicView getCurrency() {
    return currency;
  }

  public void setCurrency(BasicView currency) {
    this.currency = currency;
  }

}
