package qagardens.ims.data.managers.offline;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.qac.util.logging.Loggable;

import qagardens.ims.data.managers.StockManager;
import qagardens.ims.data.test.TestData;
import qagardens.ims.service.entities.Stock;
import qagardens.ims.service.entities.enums.StockStatus;

@Default @Stateless @Loggable
public class StockManagerOffline implements StockManager {
	@Inject
	private TestData testData;
	
	@Override
	public Stock persistStock(Stock stock) {
		testData.addStock(stock);
		return testData.getStock().get(stock.hashCode());
	}

	@Override
	public Stock findById(String id) {
		return testData.getStock().get(id);
	}

	@Override
	public List<Stock> findAll() {
		return new ArrayList<>(testData.getStock().values());
	}
	
	@Override
	public List<Stock> findByName(String name) {
		Map<Integer, Stock> map = testData.getStock();
		List<Stock> results = new ArrayList<Stock>();
		for(Stock stock : map.values())
			if(stock.getName().contains(name))
				results.add(stock);			
		return results;
	}

	@Override
	public void updateStock(Stock stock) {
		testData.addStock(stock);
	}

	@Override
	public void deleteStock(Stock stock) {
		stock.setStatus(StockStatus.DISCONTINUED);
		testData.addStock(stock);
	}
}
