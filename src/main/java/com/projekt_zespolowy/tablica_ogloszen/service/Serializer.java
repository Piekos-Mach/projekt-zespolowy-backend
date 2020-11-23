package com.projekt_zespolowy.tablica_ogloszen.service;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;

public interface Serializer {

    public default byte[] serialize(String content) {

        try (ByteArrayOutputStream byteStream = new ByteArrayOutputStream(); ObjectOutputStream objStream = new ObjectOutputStream(byteStream)) {
            objStream.writeObject(content);
            return byteStream.toByteArray();
        } catch (Exception e) {
            return new byte[]{};
        }
    }

}
