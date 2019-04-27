package com.dantorrey.shoppinglist.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Item extends BaseEntity {

    private String name;
    private Integer quantity;

    @ManyToOne
    private ItemList itemList;

    public Item() {
    }

    public Item(String name, Integer quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public ItemList getItemList() {
        return itemList;
    }

    public void setItemList(ItemList itemList) {
        this.itemList = itemList;
    }
}
