package com.qac.oc.managers;

import com.qac.oc.entities.sql.Stock;

public interface StockManager {
	Stock findById(long id);
}