package com.qac.oc.managers;

import java.util.List;

import com.qac.oc.entities.sql.Stock;

public interface WishlistManager {

	List<Stock> findByCustomerId(long id);

	void updateWishList(List<Stock> wishlist);}
