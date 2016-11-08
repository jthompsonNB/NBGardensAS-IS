package com.qac.oc.managers;

import java.util.List;

import com.qac.oc.entities.Stock;

public interface StockManager {
	public Stock findById(long id);
	public List<Stock> findByActive();
}