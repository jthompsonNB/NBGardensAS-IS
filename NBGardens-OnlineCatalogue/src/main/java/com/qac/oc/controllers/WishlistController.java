package com.qac.oc.controllers;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.qac.oc.controllers.session.CurrentUser;
import com.qac.oc.services.WishlistService;
import com.qac.oc.util.ProductItem;

/**
 * This controller handles the wishlist functionality.
 * 
 * @author James Thompson
 *
 */
@Named("wishlist")
@RequestScoped
public class WishlistController {
	@Inject
	private WishlistService wishlistService;
	@Inject
	private CurrentUser currentUser;
	private List<ProductItem> wishlist;

	/**
	 * Adds the specified product to the wishlist
	 * 
	 * @param id the ID of the product to add to the wishlist.
	 */
	public void addToWishlist(long id) {
		if(currentUser.isLoggedIn())
			wishlistService.addToWishlist(currentUser.getCustomer().getId(), id);
	}
	
	/**
	 * removes the specified product from the wishlist
	 * 
	 * @param id the product to remove
	 * @return returns wishlist
	 */
	public String removeItem(long id) {
		wishlistService.removeFromWishlist(currentUser.getCustomer().getId(), id);
		return "wishlist";
	}
	
	/**
	 * Selects the wishlist for the sessions user.
	 * 
	 * @return the list of products in the wishlist.
	 */
	public List<ProductItem> getWishlist() {
		if(wishlist==null)
			wishlist = wishlistService.getWishlist(currentUser.getCustomer().getId());
		return wishlist;
	}
}