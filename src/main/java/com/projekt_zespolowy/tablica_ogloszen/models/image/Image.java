package com.projekt_zespolowy.tablica_ogloszen.models.image;

import com.projekt_zespolowy.tablica_ogloszen.models.offer.Offer;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Image {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "image_id")
  private Long id;

  @Lob
  @Column(name = "content")
  private byte[] content = new byte[]{};

  @ManyToOne
  @JoinColumn(name = "offer")
  @Fetch(value = FetchMode.JOIN)
  private Offer offer = new Offer();

}
