package com.inhouse.trackthefood.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.inhouse.trackthefood.entities.Item;

@Service
public interface ItemService {
    Item addItem(Item item);
    Item getItem(long id);
    List<Item> getItemByName(String name);
    int getCalories(long id);
}
