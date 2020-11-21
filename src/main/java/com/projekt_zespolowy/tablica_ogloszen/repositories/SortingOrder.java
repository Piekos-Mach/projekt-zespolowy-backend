package com.projekt_zespolowy.tablica_ogloszen.repositories;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class SortingOrder {

    private List<String> valuesOrder = Lists.newArrayList();

}
