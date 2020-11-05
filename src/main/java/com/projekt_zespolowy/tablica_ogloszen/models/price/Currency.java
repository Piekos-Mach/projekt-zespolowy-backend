package com.projekt_zespolowy.tablica_ogloszen.models.price;

import java.util.HashMap;
import java.util.Map;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dictionary_currency")
public class Currency {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "currency_id")
  private Long id;

  @Column(name = "name")
  private String name;

  public Currency() {
  }

  public Currency(Long id, String name) {
    this.id = id;
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public enum CURRENCY {
    PLN(1L, "PLN");

    private static final Map<Long, Currency.CURRENCY> BY_ID = new HashMap<>();

    static {
      for (Currency.CURRENCY e : values()) {
        BY_ID.put(e.value, e);
      }
    }

    private Long value;
    private String name;

    CURRENCY(Long val, String name) {
      this.value = val;
      this.name = name;
    }

    public static Currency.CURRENCY valueOf(Long id) {
      return BY_ID.get(id);
    }

    public Long value() {
      return value;
    }

    public String getName() {
      return name;
    }

    public Currency toCurrency() {
      return new Currency(this.value, this.name);
    }

  }

}