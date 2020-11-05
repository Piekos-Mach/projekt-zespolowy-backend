package com.projekt_zespolowy.tablica_ogloszen.models.notice;

import com.google.common.collect.Lists;
import com.projekt_zespolowy.tablica_ogloszen.models.price.Price;
import com.projekt_zespolowy.tablica_ogloszen.models.user.User;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.JoinColumn;

public class Notice {

  private Long id;
  private User vendor;
  private String title;
  private String text;

  @AttributeOverrides({
      @AttributeOverride(
          name = "value",
          column = @Column(name = "price_value", scale = 2)),
  })
  @AssociationOverrides({
      @AssociationOverride(
          name = "currency",
          joinColumns = @JoinColumn(name = "price_currency_id")),
  })
  @Embedded
  private Price price;
  private List<Long> images = Lists.newArrayList();
  private LocalDate creationDate;

}
