package com.qac.oc.services;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.qac.oc.entities.sql.Stock;
import com.qac.oc.managers.StockManager;

@Stateless
public class StockService {
	@Inject
	private StockManager stockManager;
	
	public Stock findStockById(long id) {
		return stockManager.findById(id);
	}
}