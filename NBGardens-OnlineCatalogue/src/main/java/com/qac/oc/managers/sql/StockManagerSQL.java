package com.qac.oc.managers.sql;

import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

import com.qac.oc.entities.sql.Stock;
import com.qac.oc.managers.StockManager;

@Stateless
@Alternative
public class StockManagerSQL implements StockManager {
	@Override
	public Stock findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}
}
