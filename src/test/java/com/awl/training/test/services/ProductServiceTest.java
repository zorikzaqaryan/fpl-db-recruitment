package com.awl.training.test.services;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import com.awl.training.WebshopBoot;
import com.awl.training.beans.Product;
import com.awl.training.services.ProductService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(WebshopBoot.class)
public class ProductServiceTest {

	@Autowired
	private ProductService productService;

	@Test
	public void testGetProducts() {
		List<Product> allProducts = productService.getAllProducts();
		Assert.notNull(allProducts);
		Assert.notEmpty(allProducts);
	}

	@Test
	public void testGetProductNotExist() {
		Product product = productService.getProduct(-1L);
		Assert.isNull(product);
	}

	@Test
	public void testGetProductExist() {
		Product product = productService.getProduct(1L);
		Assert.notNull(product);
		Assert.isTrue(1L == product.getId());
	}

}
