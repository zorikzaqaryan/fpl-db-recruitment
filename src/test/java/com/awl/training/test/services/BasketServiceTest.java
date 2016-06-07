package com.awl.training.test.services;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import com.awl.training.WebshopBoot;
import com.awl.training.beans.Product;
import com.awl.training.services.BasketService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(WebshopBoot.class)
public class BasketServiceTest {

	private static String SESSION_ID = "SESSION_" + (new Date()).getTime();

	@Autowired
	private BasketService basketService;

	@Test
	public void testGetBasket() {
		Assert.notNull(basketService.getBasket(SESSION_ID));
	}

	@Test
	public void testAddItemOK() {
		Product product = Mockito.mock(Product.class);
		Mockito.when(product.getId()).thenReturn(1L);

		String result = basketService.addItemToBasket(SESSION_ID, product, 1);

		Assert.notNull(result);
		Assert.hasText(result);
	}

	@Test
	public void testAddItemProductKO() {
		try {
			basketService.addItemToBasket(SESSION_ID, null, -1);
		} catch (IllegalArgumentException e) {
			Assert.notNull(e);
		}
	}

	@Test
	public void testAddItemQtyKO() {
		Product product = Mockito.mock(Product.class);
		Mockito.when(product.getId()).thenReturn(1L);

		try {
			basketService.addItemToBasket(SESSION_ID, product, -1);
		} catch (IllegalArgumentException e) {
			Assert.notNull(e);
		}
	}

	@Test
	public void testAddItemQtyBiggerThanStock() {
		Product product = Mockito.mock(Product.class);
		Mockito.when(product.getId()).thenReturn(1L);

		try {
			basketService.addItemToBasket(SESSION_ID, product, (int) (product.getStock() + 1));
		} catch (IllegalArgumentException e) {
			Assert.notNull(e);
		}
	}
}
