package com.inhouse.trackthefood.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inhouse.trackthefood.entities.Item;
import com.inhouse.trackthefood.exceptions.ItemNotFoundException;
import com.inhouse.trackthefood.repositories.ItemRepository;
import com.inhouse.trackthefood.services.ItemService;

@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    ItemRepository itemRepository;

    @Override
    public Item addItem(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public Item getItem(long id) {
        return itemRepository.findById(id).orElseThrow(ItemNotFoundException::new);
    }

    @Override
    public List<Item> getItemByName(String name) {
        name = "%" + name + "%";
        return itemRepository.findAllByNameLikeIgnoreCase(name);
    }

    @Override
    public int getCalories(long id) {
        Item item = itemRepository.findById(id).orElseThrow(ItemNotFoundException::new);
        return item.getCalories();
    }

  
}
