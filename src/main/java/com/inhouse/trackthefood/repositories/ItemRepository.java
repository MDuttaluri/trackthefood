package com.inhouse.trackthefood.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inhouse.trackthefood.entities.Item;

public interface ItemRepository extends JpaRepository<Item, Long>{
    List<Item> findAllByNameLikeIgnoreCase(String name);
}
