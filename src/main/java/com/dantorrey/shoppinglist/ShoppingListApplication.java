package com.dantorrey.shoppinglist;

import com.dantorrey.shoppinglist.domain.Item;
import com.dantorrey.shoppinglist.domain.ItemList;
import com.dantorrey.shoppinglist.repo.ItemRepo;
import com.dantorrey.shoppinglist.repo.ItemListRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.Collections;

@SpringBootApplication
public class ShoppingListApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingListApplication.class, args);
	}

	@Autowired
	ItemRepo itemRepo;

	@Autowired
	ItemListRepo itemListRepo;

    /**
     * Allow web requests from the web interface.
     * @return
     */
	@Bean
	public FilterRegistrationBean<CorsFilter> simpleCorsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.setAllowedOrigins(Arrays.asList("http://localhost:3000"));
		config.setAllowedMethods(Collections.singletonList("*"));
		config.setAllowedHeaders(Collections.singletonList("*"));
		source.registerCorsConfiguration("/**", config);
		FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(new CorsFilter(source));
		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return bean;
	}

	/**
	 * Add some test data.
	 */
	@PostConstruct
	public void loadData() {

		// Add a new list.
		ItemList list = ItemList.newInstance();
		list.addItem(new Item("Beer", 12));
		list.addItem(new Item("Cereal", 2));
		list.addItem(new Item("Milk", 1));
		list.addItem(new Item("Bread", 4));
		list.addItem(new Item("Donuts",2));
		list.addItem(new Item("La Croax",4));
		list.addItem(new Item("Cheese",1));
		itemListRepo.save(list);

		ItemList anotherList = ItemList.newInstance();
		anotherList.addItem(new Item("Paper Towels", 1 ));
		anotherList.addItem(new Item("Soap", 2));
		anotherList.addItem(new Item("Pair of Shoes", 1 ));
		anotherList.addItem(new Item("Tooth Paste", 2 ));
		itemListRepo.save(anotherList);
	}
}
