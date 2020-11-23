package com.projekt_zespolowy.tablica_ogloszen.service;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;

public interface Deserializer {

    public default String deserialize(byte[] content){

        try (ByteArrayInputStream byteStream = new ByteArrayInputStream(content); ObjectInputStream objStream = new ObjectInputStream(byteStream)) {
            return (String) objStream.readObject();
        } catch (Exception e) {
            return "";
        }
    }

}
