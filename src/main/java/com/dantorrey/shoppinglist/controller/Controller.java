package com.dantorrey.shoppinglist.controller;

import com.dantorrey.shoppinglist.domain.Item;
import com.dantorrey.shoppinglist.repo.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private ItemRepo itemRepo;

    @Autowired
    public Controller(ItemRepo itemRepo) {
        this.itemRepo = itemRepo;
    }

    @GetMapping(value = "allItems", produces = "application/json")
    public Iterable<Item> all() {

        return itemRepo.findAll();
    }


}
