package com.qac.oc.managers;

import java.util.List;

import com.qac.oc.entities.Stock;

/**
 * This is the entity manager for wishlists
 * 
 * @author James Thompson
 *
 */
public interface WishlistManager {
	/**
	 * Finds a customers wishlist
	 * 
	 * @param id
	 * @return
	 */
	List<Stock> findByCustomerId(long id);
	
	/**
	 * Updates a customers wishlist.
	 * 
	 * @param customerId
	 * @param wishlist
	 */
	void updateWishList(long customerId, List<Stock> wishlist);
}