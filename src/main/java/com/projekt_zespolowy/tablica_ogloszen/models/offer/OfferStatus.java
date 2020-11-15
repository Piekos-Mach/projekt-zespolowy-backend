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
@Table(name = "dictionary_notice_status")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OfferStatus {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "notice_status_id")
  private Long id;

  @Column(name = "name")
  private String name;

  public enum NOTICE_STATUS {
    ACTIVE(1L),
    ARCHIVAL(2L);

    private static final Map<Long, NOTICE_STATUS> BY_ID = new HashMap<>();

    static {
      for (NOTICE_STATUS e : values()) {
        BY_ID.put(e.id, e);
      }
    }

    private Long id;

    NOTICE_STATUS(Long id) {
      this.id = id;
    }

    public static NOTICE_STATUS idOf(Long id) {
      return BY_ID.get(id);
    }

    public Long getId() {
      return this.id;
    }

    public OfferStatus toNoticeStatus() {
      return new OfferStatus(this.id, this.name());
    }

  }

}