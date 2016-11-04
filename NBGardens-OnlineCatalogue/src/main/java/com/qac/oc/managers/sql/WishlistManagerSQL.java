package com.qac.oc.managers.sql;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

import com.qac.oc.entities.sql.Stock;
import com.qac.oc.managers.WishlistManager;

@Stateless
@Alternative
public class WishlistManagerSQL implements WishlistManager {
	@Override
	public List<Stock> findByCustomerId(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateWishList(long customerId, List<Stock> wishlist) {
		// TODO Auto-generated method stub
	}
}
