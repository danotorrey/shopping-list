package com.dantorrey.shoppinglist.domain;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ItemList extends BaseEntity {

    private String name;

    @OneToMany(mappedBy = "itemList")
    private List<Item> items;

    public static ItemList newInstance() {

        ItemList itemList = new ItemList();
        itemList.setItems(new ArrayList<>());
        return itemList;
    }

    public void addItem(Item item) {

        item.setItemList(this);
        this.getItems().add(item);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
