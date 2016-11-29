package com.qac.oc.managers;

import java.util.List;

import com.qac.oc.entities.Stock;

/**
 * This is the entity manager for the stock entity
 * 
 * @author James Thompson
 *
 */
public interface StockManager {
	/**
	 * Finds a specific stock line
	 * 
	 * @param id
	 * @return
	 */
	public Stock findById(long id);
	
	/**
	 * Finds all active stock lines
	 * 
	 * @return
	 */
	public List<Stock> findByActive();
}