package com.projekt_zespolowy.tablica_ogloszen.models.user;

import com.google.common.collect.Lists;
import com.projekt_zespolowy.tablica_ogloszen.config.security.Role;
import com.projekt_zespolowy.tablica_ogloszen.models.offer.Offer;
import java.util.Collection;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements UserDetails {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "user_id")
  private Long id;

  @ManyToOne
  @JoinColumn(name = "type")
  @Fetch(value = FetchMode.JOIN)
  private UserType type;

  @Column(name = "name")
  private String name;

  @Column(name = "password")
  private String password;

  @Column(name = "mail")
  private String mail;

  // TODO: zamienic na lazy
  @OneToMany(mappedBy = "owner", fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
//    @Fetch(value = FetchMode.SUBSELECT)
  private List<Offer> offers = Lists.newArrayList();

  @ManyToOne
  @JoinColumn(name = "role")
  @Fetch(value = FetchMode.JOIN)
  private Role role;

  public void setOffers(List<Offer> offers) {
    this.offers.clear();
    for (Offer offer : offers) {
      offer.setOwner(this);
      this.offers.add(offer);
    }
  }

  public void addOffer(Offer offer) {
    this.offers.add(offer);
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {

    return Lists.newArrayList(this.role);
  }

  @Override
  public String getUsername() {

    return this.name;
  }

  @Override
  public boolean isAccountNonExpired() {

    return true;
  }

  @Override
  public boolean isAccountNonLocked() {

    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {

    return true;
  }

  @Override
  public boolean isEnabled() {

    return true;
  }

}
