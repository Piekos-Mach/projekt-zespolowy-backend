package com.projekt_zespolowy.tablica_ogloszen.models.user;

import com.google.common.collect.Lists;
import com.projekt_zespolowy.tablica_ogloszen.models.offer.Offer;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "user_id")
  private Long id;

  @ManyToOne
  @JoinColumn(name = "user_type_id")
  private UserType type;

  @Column(name = "name")
  private String name;

  @Column(name = "password")
  private String password;

  @Column(name = "mail")
  private String mail;

  @OneToMany(mappedBy = "owner")
  private List<Offer> offers = Lists.newArrayList();

  public void setOffers(List<Offer> offers) {
    this.offers = Lists.newArrayList();
    for (Offer offer : offers) {
      offer.setOwner(this);
      this.offers.add(offer);
    }
  }

  public void addOffer(Offer offer) {
    this.offers.add(offer);
  }

}
