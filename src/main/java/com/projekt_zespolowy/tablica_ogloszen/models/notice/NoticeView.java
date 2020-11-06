package com.projekt_zespolowy.tablica_ogloszen.models.notice;

import com.google.common.collect.Lists;
import com.projekt_zespolowy.tablica_ogloszen.models.image.Image;
import com.projekt_zespolowy.tablica_ogloszen.models.price.PriceView;
import com.projekt_zespolowy.tablica_ogloszen.models.user.UserView;
import java.time.LocalDateTime;
import java.util.List;

public class NoticeView {

  private Long id;
  private UserView vendor = new UserView();
  private String title;
  private String text;
  private PriceView price = new PriceView();
  private List<Image> images = Lists.newArrayList();
  private LocalDateTime creationDate;

  public NoticeView() {
  }

  public NoticeView(Long id, UserView vendor, String title, String text,
      PriceView price,
      List<Image> images, LocalDateTime creationDate) {
    this.id = id;
    this.vendor = vendor;
    this.title = title;
    this.text = text;
    this.price = price;
    this.images = images;
    this.creationDate = creationDate;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public UserView getVendor() {
    return vendor;
  }

  public void setVendor(UserView vendor) {
    this.vendor = vendor;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public PriceView getPrice() {
    return price;
  }

  public void setPrice(PriceView price) {
    this.price = price;
  }

  public List<Image> getImages() {
    return images;
  }

  public void setImages(List<Image> images) {
    this.images = images;
  }

  public LocalDateTime getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(LocalDateTime creationDate) {
    this.creationDate = creationDate;
  }

}
