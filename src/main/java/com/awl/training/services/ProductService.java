package com.awl.training.services;

import java.util.List;

import com.awl.training.beans.Product;

/**
 * The Interface ProductService.
 * 
 * @author A132242
 */
public interface ProductService {

	/**
	 * Return all products.<br>
	 * If no product, return an empty list.
	 *
	 * @return a list of {@link Product}
	 */
	List<Product> getAllProducts();

	/**
	 * Return an {@link Product} corresponds to the given productId<br>
	 * If no product, return null.
	 *
	 * @return a {@link Product}
	 */
	Product getProduct(long productId);

	/**
	 * Checks if a specific product is available.<br>
	 * This specific product corresponds to the given productId.
	 *
	 * @param productId
	 *            the product id
	 * @param quantity
	 *            the asked quantity
	 * @return true, if the product is available
	 */
	boolean isProductAvailable(long productId, int quantity);
}
