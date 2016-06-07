package com.awl.training.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.awl.training.beans.Product;
import com.awl.training.services.WebshopService;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private WebshopService webshopService;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public @ResponseBody List<Product> getProducts() {
		List<Product> products = webshopService.getAllProducts();
		logger.info("Retrieve all product [{}]", (CollectionUtils.isEmpty(products) ? 0 : products.size()));
		return products;
	}
}
