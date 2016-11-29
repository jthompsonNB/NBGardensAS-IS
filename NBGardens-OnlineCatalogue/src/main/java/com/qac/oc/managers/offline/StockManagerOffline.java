package com.qac.oc.managers.offline;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.qac.oc.entities.Stock;
import com.qac.oc.enums.ProductStatus;
import com.qac.oc.managers.StockManager;
import com.qac.oc.util.TestData;

/**
 * This implementation is to be used while there is no datastore to pull data from
 * 
 * @author James Thompson
 *
 */
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

	@Override
	public List<Stock> findByActive() {
		List<Stock> stock = new ArrayList<Stock>();
		testData.getStock().forEach(s->{
			if(s.getStatus().equals(ProductStatus.ACTIVE) || s.getStockLevel()>0)
				stock.add(s);
		});
		return stock;
	}
}