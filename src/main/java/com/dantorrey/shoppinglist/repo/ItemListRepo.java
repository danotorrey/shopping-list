package com.dantorrey.shoppinglist.repo;

import com.dantorrey.shoppinglist.domain.Item;
import com.dantorrey.shoppinglist.domain.ItemList;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "itemList", path = "itemList")
public interface ItemListRepo extends PagingAndSortingRepository<ItemList, Long> {

    @RestResource(path="byName")
    List<ItemList> findItemByNameContainingIgnoreCase(String name);
}
