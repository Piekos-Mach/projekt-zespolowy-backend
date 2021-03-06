package com.projekt_zespolowy.tablica_ogloszen.models.offer;

import java.util.HashMap;
import java.util.Map;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "dictionary_offer_status")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OfferStatus {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "offer_status_id")
  private Long id;

  @Column(name = "name")
  private String name;

  public enum OFFER_STATUS {
    ACTIVE(1L),
    ARCHIVAL(2L);

    private static final Map<Long, OFFER_STATUS> BY_ID = new HashMap<>();

    static {
      for (OFFER_STATUS e : values()) {
        BY_ID.put(e.id, e);
      }
    }

    private Long id;

    OFFER_STATUS(Long id) {
      this.id = id;
    }

    public static OFFER_STATUS idOf(Long id) {
      return BY_ID.get(id);
    }

    public Long getId() {
      return this.id;
    }

    public OfferStatus toOfferStatus() {
      return new OfferStatus(this.id, this.name());
    }

  }

}