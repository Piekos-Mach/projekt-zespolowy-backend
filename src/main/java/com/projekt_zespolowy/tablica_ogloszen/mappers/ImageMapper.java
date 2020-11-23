package com.projekt_zespolowy.tablica_ogloszen.mappers;

import com.projekt_zespolowy.tablica_ogloszen.models.image.CreateImageCmd;
import com.projekt_zespolowy.tablica_ogloszen.models.image.Image;
import com.projekt_zespolowy.tablica_ogloszen.models.image.ImageView;
import org.mapstruct.*;

import java.io.*;
import java.util.List;

@Mapper(
        componentModel = "spring",
        uses = {
                MapperClassService.class,
                MapperResolverService.class,
                OfferMapper.class,
                UserMapper.class,
                PriceMapper.class
        },
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public abstract class ImageMapper {

    @Named(value = "imageCmdToEntity")
    @Mappings({
            @Mapping(target = "content", source = "content", qualifiedByName = "stringImageToByte")
    })
    public abstract Image createCmdToEntity(CreateImageCmd cmd);

    @Named(value = "imageToView")
    @Mappings({
            @Mapping(target = "content", source = "content", qualifiedByName = "byteImageToString")
    })
    public abstract ImageView entityToView(Image entity);

    @Named(value = "byteImageToString")
    public String byteImageToString(byte[] content) throws IOException, ClassNotFoundException {

        try (ByteArrayInputStream byteStream = new ByteArrayInputStream(content); ObjectInputStream objStream = new ObjectInputStream(byteStream)) {
            return (String) objStream.readObject();
        } catch (Exception e) {
            return "";
        }
    }

    @IterableMapping(qualifiedByName = "imageToView")
    public abstract List<ImageView> entitiesToViews(List<Image> entities);

    @IterableMapping(qualifiedByName = "imageCmdToEntity")
    public abstract List<Image> createCmdsToEntities(List<CreateImageCmd> cmds);

    @Named(value = "stringImageToByte")
    public byte[] stringImageToByte(String content) throws IOException, ClassNotFoundException {

        try (ByteArrayOutputStream byteStream = new ByteArrayOutputStream(); ObjectOutputStream objStream = new ObjectOutputStream(byteStream)) {
            objStream.writeObject(content);
            return byteStream.toByteArray();
        } catch (Exception e) {
            return new byte[]{};
        }
    }

    @Named(value = "imageToString")
    public String entityToString(Image entity) throws IOException, ClassNotFoundException {
        return this.byteImageToString(entity.getContent());
    }

    @IterableMapping(qualifiedByName = "imageToString")
    public abstract List<String> entitiesToStrings(List<Image> entities);

    public ImageView entitiesToMiniatureView(List<Image> entities) {

        ImageView viewModel = entities != null && entities.size() >= 1 ? entityToView(entities.get(0)) : new ImageView();

        return viewModel;
    }

}
