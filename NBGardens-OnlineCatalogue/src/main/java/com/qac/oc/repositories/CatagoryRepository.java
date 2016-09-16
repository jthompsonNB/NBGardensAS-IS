package com.qac.oc.repositories;

import java.util.List;
import java.util.logging.Logger;

import com.qac.oc.entities.Catagory;

public interface CatagoryRepository {
	static Logger logger = Logger.getLogger("CatagoryReository");
	
	public List<Catagory> findByCatagory(String catagory);
}