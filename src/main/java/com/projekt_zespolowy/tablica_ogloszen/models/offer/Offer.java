package com.projekt_zespolowy.tablica_ogloszen.models.offer;

import com.google.common.collect.Lists;
import com.projekt_zespolowy.tablica_ogloszen.models.image.Image;
import com.projekt_zespolowy.tablica_ogloszen.models.price.Price;
import com.projekt_zespolowy.tablica_ogloszen.models.user.User;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Table(name = "offer")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "offer_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "owning_user")
    @Fetch(value = FetchMode.JOIN)
    private User owner = new User();

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
                    joinColumns = @JoinColumn(name = "price_currency")),
    })
    @Embedded
    private Price price = new Price();

    // TODO: Zamienic na lazy
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "offer", orphanRemoval = true, cascade = {CascadeType.ALL})
//    @Fetch(value = FetchMode.SUBSELECT)
    private List<Image> images = Lists.newArrayList();

    @DateTimeFormat(iso = ISO.DATE_TIME)
    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @ManyToOne
    @JoinColumn(name = "status")
    @Fetch(value = FetchMode.JOIN)
    private OfferStatus status = new OfferStatus();

    @ManyToOne
    @JoinColumn(name = "type")
    @Fetch(value = FetchMode.JOIN)
    private OfferType type = new OfferType();

    public void setImages(List<Image> images) {

        this.getImages().clear();
        for (Image image : images) {
            this.addImage(image);
        }
    }

    public void addImage(Image image) {

        image.setOffer(this);
        this.getImages().add(image);
    }

    public void addImages(List<Image> images) {

        for (Image image : images) {
            this.addImage(image);
        }
    }

}
