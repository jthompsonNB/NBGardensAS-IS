package com.qac.oc.controllers;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.qac.oc.controllers.session.CurrentUser;
import com.qac.oc.services.WishlistService;
import com.qac.oc.util.ProductItem;

@Named("wishlist")
@RequestScoped
public class WishlistController {
	@Inject
	private WishlistService wishlistService;
	@Inject
	private CurrentUser currentUser;
	private List<ProductItem> wishlist;

	public void addToWishlist(long id) {
		wishlistService.addToWishlist(currentUser.getCustomer().getId(), id);
	}
	
	public String removeItem(long id) {
		wishlist = wishlistService.removeFromWishlist(currentUser.getCustomer().getId(), id);
		return "wishlist";
	}
	
	public void removeFromWishList(long id) {
		wishlist = wishlistService.removeFromWishlist(currentUser.getCustomer().getId(), id);
	}
	
	public List<ProductItem> getWishlist() {
		if(wishlist==null)
			wishlist = wishlistService.getWishlist(currentUser.getCustomer().getId());
		return wishlist;
	}
}