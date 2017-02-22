package qagardens.ims.data.managers.online;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import com.qac.util.logging.Loggable;

import qagardens.ims.data.managers.StockManager;
import qagardens.ims.service.entities.Stock;
import qagardens.ims.service.entities.enums.StockStatus;

@Alternative
@Stateless
@Loggable
@Transactional(rollbackOn=Exception.class)
public class StockManagerOnline implements StockManager {
	@PersistenceContext(unitName="qagardensPU")
	private EntityManager entityManager;
	
	@Override
	public Stock persistStock(Stock stock) {
		entityManager.getTransaction().begin();
		entityManager.persist(stock);
		entityManager.getTransaction().commit();
		return findByName(stock.getName()).get(0);
	}

	@Override
	public Stock findById(String id) {
		return entityManager.find(Stock.class, id);
	}

	@Override
	public List<Stock> findAll() {
		TypedQuery<Stock> query = entityManager.createNamedQuery(Stock.FIND_ALL, Stock.class);
		return query.getResultList();
	}
	
	@Override
	public List<Stock> findByName(String name) {
		TypedQuery<Stock> query = entityManager.createNamedQuery(Stock.FIND_BY_NAME, Stock.class);
		query.setParameter("name", name);
		return query.getResultList();
	}

	@Override
	public void updateStock(Stock stock) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(stock);
			entityManager.getTransaction().commit();
		} catch(IllegalArgumentException iae) {
			entityManager.getTransaction().rollback();
		}
	}

	@Override
	public void deleteStock(Stock stock) {
		stock.setStatus(StockStatus.DISCONTINUED);
		entityManager.getTransaction().begin();
		entityManager.merge(stock);
		entityManager.getTransaction().commit();
	}
}