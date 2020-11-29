package com.projekt_zespolowy.tablica_ogloszen.models.user;

import com.google.common.collect.Lists;
import com.projekt_zespolowy.tablica_ogloszen.models.offer.Offer;

import java.util.List;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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
    @JoinColumn(name = "type")
    @Fetch(value = FetchMode.JOIN)
    private UserType type = new UserType();

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

}
