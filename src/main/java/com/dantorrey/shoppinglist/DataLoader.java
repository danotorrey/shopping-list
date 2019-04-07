package com.dantorrey.shoppinglist;

import com.dantorrey.shoppinglist.domain.Item;
import com.dantorrey.shoppinglist.repo.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DataLoader {

    private ItemRepo itemRepo;

    @Autowired
    public DataLoader(ItemRepo itemRepo) {
        this.itemRepo = itemRepo;
    }

    @PostConstruct
    public void loadData() {

        itemRepo.save(new Item("Beer", 6));
        itemRepo.save(new Item("Pretzels", 1));

    }
}
