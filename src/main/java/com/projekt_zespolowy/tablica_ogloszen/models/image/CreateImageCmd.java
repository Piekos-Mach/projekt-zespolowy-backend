package com.projekt_zespolowy.tablica_ogloszen.models.image;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class  CreateImageCmd {

  private String content;
  private Long offer;

}
