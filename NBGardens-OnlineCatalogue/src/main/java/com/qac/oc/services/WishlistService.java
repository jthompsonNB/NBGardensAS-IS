package com.qac.oc.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.qac.oc.entities.Stock;
import com.qac.oc.managers.ProductManager;
import com.qac.oc.managers.StockManager;
import com.qac.oc.managers.WishlistManager;
import com.qac.oc.util.ProductItem;

@Stateless
public class WishlistService {
	@Inject
	private WishlistManager wishlistManager;
	@Inject
	private ProductManager productManager;
	@Inject
	private ProductService productService;
	@Inject
	private StockManager stockManager;

	public List<ProductItem> getWishlist(long id) {
		List<ProductItem> wishlist = new ArrayList<>();
		wishlistManager.findByCustomerId(id).forEach(stock->{
			wishlist.add(productService.getProductItem(productManager.findById(stock.getId()), stock));	
		});
		return wishlist;
	}
	
	public void addToWishlist(long customerId, long productId) {
		List<Stock> wishlist = wishlistManager.findByCustomerId(customerId);
		for(Stock stock : wishlist)
			if(stock.getId() == productId)
				return;
		wishlist.add(stockManager.findById(productId));
		wishlistManager.updateWishList(customerId, wishlist);
	}

	public List<ProductItem> removeFromWishlist(long customerId, long productId) {
		List<Stock> wishlist = wishlistManager.findByCustomerId(customerId);
		for(Stock stock : wishlist)
			if(stock.getId() == productId)
				wishlist.remove(stock);
		wishlistManager.updateWishList(customerId, wishlist);
		return getWishlist(customerId);
	}
}