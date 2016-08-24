package com.qac.oc.repositories;

import java.util.List;

import com.qac.oc.entities.Catagory;

public interface CatagoryRepository {
	public List<Catagory> findByCatagory(String catagory);
}