//package com.qac.oc.managers.sql;
//
//import java.util.List;
//
//import javax.annotation.Resource;
//import javax.ejb.Stateless;
//import javax.enterprise.inject.Alternative;
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.transaction.HeuristicMixedException;
//import javax.transaction.HeuristicRollbackException;
//import javax.transaction.NotSupportedException;
//import javax.transaction.RollbackException;
//import javax.transaction.SystemException;
//import javax.transaction.UserTransaction;
//
//import com.qac.oc.entities.Customer;
//import com.qac.oc.entities.Stock;
//import com.qac.oc.managers.WishlistManager;
//
//@Stateless
//@Alternative
//public class WishlistManagerSQL implements WishlistManager {
//	@PersistenceContext(unitName="OnlineCatalogue")
//	private EntityManager entityManager;
//	@Resource
//	private UserTransaction transaction;
//	
//	@Override
//	public List<Stock> findByCustomerId(long id) {
//		return entityManager.find(Customer.class, id).getWishlist();
//	}
//
//	@Override
//	public void updateWishList(long customerId, List<Stock> wishlist) {
//		Customer customer = entityManager.find(Customer.class, customerId);
//		customer.setWishlist(wishlist);
//		try {
//			transaction.begin();
//			entityManager.merge(customer);
//			transaction.commit();
//		} catch(NotSupportedException | SystemException | SecurityException | IllegalStateException | RollbackException | HeuristicMixedException | HeuristicRollbackException e) {
//			e.printStackTrace();
//			try {
//				transaction.rollback();
//			} catch(IllegalStateException | SecurityException | SystemException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//		}
//	}
//}
