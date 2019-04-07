package com.dantorrey.shoppinglist.repo;

import com.dantorrey.shoppinglist.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "item", path = "item")
public interface ItemRepo extends PagingAndSortingRepository<Item, Long> {

}
