package com.projekt_zespolowy.tablica_ogloszen.models.image;

import com.projekt_zespolowy.tablica_ogloszen.service.Deserializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Data
public class ImageView implements Deserializer {

    private Long id;
    private String content;
    private Long offer;

    public ImageView(Long id, byte[] content, Long offer) {

        this.id = id;
        this.content = deserialize(content);
        this.offer = offer;
    }

}
