package com.dantorrey.shoppinglist;

import com.dantorrey.shoppinglist.repo.ItemListRepo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShoppingListApplicationTests {

    @Autowired
    ItemListRepo itemListRepo;

    @Test
    public void contextLoads() {
    }

    /**
     * Verify that test data was correctly loaded on initialization.
     */
    @Test
    public void testDataLoaded() {

        ArrayList<Object> itemLists = new ArrayList<>();

        // Err, need to convert iterable into a list.
        itemListRepo.findAll().forEach(itemLists::add);
        Assert.assertEquals(2, itemLists.size());
    }
}
