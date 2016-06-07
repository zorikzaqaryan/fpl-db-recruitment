package com.awl.training.test.services;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import com.awl.training.WebshopBoot;
import com.awl.training.beans.Basket;
import com.awl.training.beans.Product;
import com.awl.training.services.WebshopService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(WebshopBoot.class)
public class WebshopServiceTest {

	private static String SESSION_ID = "SESSION_" + (new Date()).getTime();

	@Autowired
	private WebshopService webshopService;

	@Test
	public void testGetProducts() {
		List<Product> allProducts = webshopService.getAllProducts();
		Assert.notNull(allProducts);
		Assert.notEmpty(allProducts);
	}

	@Test
	public void testGetProductNotExist() {
		Product product = webshopService.getProduct(-1L);
		Assert.isNull(product);
	}

	@Test
	public void testGetProductExist() {
		Product product = webshopService.getProduct(1L);
		Assert.notNull(product);
		Assert.isTrue(1L == product.getId());
	}

	@Test
	public void testGetBasket() {
		Basket basket = webshopService.getBasket(SESSION_ID);
		Assert.notNull(basket);
		Assert.isTrue(SESSION_ID.equals(basket.getSessionId()));
	}

	@Test
	public void testIsProductAvailableOK() {
		Assert.isTrue(webshopService.isProductAvailable(1L, 1));
	}

	@Test
	public void testIsProductAvailableProductKO() {
		Assert.isTrue(!webshopService.isProductAvailable(-1L, 9999999));
	}

	@Test
	public void testIsProductAvailableQtyNegateKO() {
		Assert.isTrue(!webshopService.isProductAvailable(1L, -1));
	}

	@Test
	public void testAddItemOK() {
		String result = webshopService.addItemToBasket(SESSION_ID, 1, 1);
		Assert.notNull(result);
	}

	@Test
	public void testAddItemProductKo() {
		try {
			webshopService.addItemToBasket(SESSION_ID, -1, 1);
		} catch (IllegalArgumentException e) {
			Assert.notNull(e);
		}
	}

	@Test
	public void testAddItemQtyKO() {
		try {
			webshopService.addItemToBasket(SESSION_ID, 1, -1);
		} catch (IllegalArgumentException e) {
			Assert.notNull(e);
		}
	}
}
