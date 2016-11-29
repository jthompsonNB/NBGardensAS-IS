//package com.qac.oc.managers.sql;
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
//import com.qac.oc.managers.CustomerManager;
//
///**
// * This implementation is to be used to pull data from an SQL database
// * 
// * @author James Thompson
// *
// */
//@Alternative
//@Stateless
//public class CustomerManagerSQL implements CustomerManager {
//	@PersistenceContext(unitName = "OnlineCatalogue")
//	private EntityManager entityManager;
//	@Resource
//	private UserTransaction transaction;
//
//	@Override
//	public Customer findByEmail(String email) {
//		return entityManager.createNamedQuery("findByEmail", Customer.class).setParameter("email", email).getSingleResult();
//	}
//
//	@Override
//	public Customer createNewCustomer(Customer customer) {
//		try {
//			transaction.begin();
//			entityManager.persist(customer);
//			transaction.commit();
//		} catch(NotSupportedException | SystemException | SecurityException | IllegalStateException | RollbackException | HeuristicMixedException | HeuristicRollbackException e) {
//			e.printStackTrace();
//			try {
//				transaction.rollback();
//			} catch(IllegalStateException | SecurityException | SystemException e1) {
//				e1.printStackTrace();
//			}
//		}
//		return findByEmail(customer.getEmail());
//	}
//}