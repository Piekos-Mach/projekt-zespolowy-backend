package com.projekt_zespolowy.tablica_ogloszen.models.notice;

import com.google.common.collect.Lists;
import com.projekt_zespolowy.tablica_ogloszen.models.image.Image;
import com.projekt_zespolowy.tablica_ogloszen.models.price.Price;
import com.projekt_zespolowy.tablica_ogloszen.models.user.User;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notice {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "notice_id")
  private Long id;

  @ManyToOne
  @Column(name = "vendor_user_id")
  private User vendor;

  @Column(name = "title")
  private String title;

  @Column(name = "text")
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

  @OneToMany(mappedBy = "notice", orphanRemoval = true, cascade = {CascadeType.REMOVE,
      CascadeType.PERSIST})
  private List<Image> images = Lists.newArrayList();

  @DateTimeFormat(iso = ISO.DATE_TIME)
  @Column(name = "creation_date")
  private LocalDateTime creationDate;

  @ManyToOne
  @JoinColumn(name = "notice_status_id")
  private NoticeStatus status;

}
