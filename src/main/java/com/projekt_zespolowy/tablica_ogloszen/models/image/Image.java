package com.projekt_zespolowy.tablica_ogloszen.models.image;

import com.projekt_zespolowy.tablica_ogloszen.models.notice.Offer;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
  private byte[] content;

  @ManyToOne
  @Column(name = "offer")
  private Offer offer;

}
