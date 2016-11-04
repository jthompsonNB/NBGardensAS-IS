package com.qac.oc.managers.offline;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.qac.oc.entities.sql.Stock;
import com.qac.oc.managers.StockManager;
import com.qac.oc.util.TestData;

@Stateless
@Default
public class StockManagerOffline implements StockManager {
	@Inject
	private TestData testData;
	
	@Override
	public Stock findById(long id) {
		for(Stock stock : testData.getStock())
			if(stock.getId() == id)
				return stock;
		return null;
	}
}