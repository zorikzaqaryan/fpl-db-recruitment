package com.awl.training.services;

import com.awl.training.beans.Basket;
import com.awl.training.beans.Product;

/**
 * The Interface BasketService.
 * 
 * @author A132242
 */
public interface BasketService {

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
	 * @param product
	 *            the {@link Product}
	 * @param quantity
	 *            the quantity
	 * @return the string
	 * @throws IllegalArgumentException
	 *             the illegal argument exception
	 */
	String addItemToBasket(String sessionId, Product product, int quantity) throws IllegalArgumentException;


	/**
	 * Remove an item from basket.
	 *
	 * @param sessionId
	 *            the session id
	 * @param product
	 *            the {@link Product}
	 * @throws IllegalArgumentException
	 *             the illegal argument exception
	 */
	void removeItemFromBasket (String sessionId, Product product) throws IllegalArgumentException;
}
