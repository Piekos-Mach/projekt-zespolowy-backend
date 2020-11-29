package com.projekt_zespolowy.tablica_ogloszen.initialization.processes;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.projekt_zespolowy.tablica_ogloszen.models.image.Image;
import com.projekt_zespolowy.tablica_ogloszen.models.offer.Offer;
import com.projekt_zespolowy.tablica_ogloszen.repositories.offer.OfferRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;
import java.util.Set;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class InitializationImagesResolver {

    private final OfferRepository offerRepository;

    public void run(List<Image> images) {

        this.initializeExampleNotices(images);
    }

    @Transactional
    public void initializeExampleNotices(List<Image> images) {

        List<Offer> allOffers = offerRepository.findAll();
        for (Offer offer : allOffers) {
            List<Image> imagesOfOffer = this.getRandomImages(images);
            offer.setImages(imagesOfOffer);
            //TODO: przerobic batch update
            offerRepository.save(offer);
        }
    }

    public List<Image> getRandomImages(List<Image> images) {

        List<Image> result = Lists.newArrayList();
        Set<Image> drawedImages = Sets.newHashSet();
        int iterationNumber = new Random().nextInt(images.size());
        int index;
        for (int i = 0; i < iterationNumber; i++) {
            index = new Random().nextInt(images.size());
            drawedImages.add(images.get(index));
        }
        result.addAll(drawedImages);

        return result;
    }

}
