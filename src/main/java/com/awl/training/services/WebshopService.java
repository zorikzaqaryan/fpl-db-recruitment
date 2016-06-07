package com.awl.training.services;

import java.util.List;

import com.awl.training.beans.Basket;
import com.awl.training.beans.Product;

/**
 * The Interface WebshopService.
 * 
 * @author A132242
 */
public interface WebshopService {

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

	/**
	 * Return an {@link Basket} corresponds to the given sessionid<br>
	 * If the basket does not exist, it will be created.
	 *
	 * @return a {@link Basket}
	 */
	Basket getBasket(String sessionId);

	/**
	 * Add an item into a specific basket.
	 *
	 * @param sessionId
	 *            the session id
	 * @param productId
	 *            the product id
	 * @param quantity
	 *            the quantity
	 * @return the string
	 * @throws IllegalArgumentException
	 *             the illegal argument exception
	 */
	String addItemToBasket(String sessionId, long productId, int quantity) throws IllegalArgumentException;

	/**
	 * Remove an item from a basket.
	 *
	 * @param sessionId
	 *            the session id
	 * @param productId
	 *            the product id
	 * @throws IllegalArgumentException
	 *             the illegal argument exception
	 */
	void removeItemToBasket(String sessionId, long productId) throws IllegalArgumentException;

}
