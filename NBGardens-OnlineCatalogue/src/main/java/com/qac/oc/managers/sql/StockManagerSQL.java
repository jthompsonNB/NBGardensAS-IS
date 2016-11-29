//package com.qac.oc.managers.sql;
//
//import java.util.List;
//
//import javax.ejb.Stateless;
//import javax.enterprise.inject.Alternative;
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//
//import com.qac.oc.entities.Stock;
//import com.qac.oc.managers.StockManager;
//
///**
// * This implementation is to be used to pull data from an SQL database
// * 
// * @author James Thompson
// *
// */
//@Stateless
//@Alternative
//public class StockManagerSQL implements StockManager {
//	@PersistenceContext(unitName="OnlineCatalogue")
//	private EntityManager entityManager;
//	
//	@Override
//	public Stock findById(long id) {
//		return entityManager.find(Stock.class, id);
//	}
//
//	@Override
//	public List<Stock> findByActive() {
//		return entityManager.createNamedQuery("findExcludingDiscontinued", Stock.class).getResultList();
//	}
//}