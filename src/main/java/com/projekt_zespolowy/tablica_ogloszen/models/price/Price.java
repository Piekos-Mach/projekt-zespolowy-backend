package com.projekt_zespolowy.tablica_ogloszen.models.price;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Price {

  @Column(name = "price_value")
  private BigDecimal value;

  @ManyToOne
  @JoinColumn(name = "currency_id")
  private Currency currency;

}
