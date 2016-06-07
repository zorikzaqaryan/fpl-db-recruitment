package com.awl.training.services.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import predicates.ProductIdPredicate;

import com.awl.training.beans.Product;
import com.awl.training.services.ProductService;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;

/**
 * The Class ProductServiceImpl is the default implemenatation of ProductService.
 */
@Service
public class ProductServiceImpl implements ProductService {

	private static int MIN = 1;
	private static int MAX = 5000;

	private List<Product> products = new ArrayList<Product>();

	@PostConstruct
	public void init() {
		for (int i = 0; i < 100; i++) {
			Random r = new Random();

			BigDecimal price = new BigDecimal(Math.floor((MIN + (MAX - MIN) * r.nextDouble()) * 100) / 100);
			BigDecimal fee = new BigDecimal(Math.floor(price.doubleValue() * 3) / 100);

			products.add(new Product(i, "Product " + i, "Description Product " + i, price, fee, Math.round(100 * Math.random())));
		}
	}

	@Override
	public List<Product> getAllProducts() {
		return ImmutableList.copyOf(products);
	}

	@Override
	public Product getProduct(long productId) {
		return Iterables.tryFind(products, new ProductIdPredicate(productId)).orNull();
	}

	@Override
	public boolean isProductAvailable(long productId, int quantity) {
		return Iterables.any(products, new ProductIdPredicate(productId));
	}
}
