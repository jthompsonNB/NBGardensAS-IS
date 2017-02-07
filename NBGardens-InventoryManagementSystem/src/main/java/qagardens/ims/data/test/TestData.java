package qagardens.ims.data.test;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import qagardens.ims.service.entities.pojos.Stock;

@Startup
@Singleton
public class TestData {

	//public static TestData data = new TestData();
	private Map<Integer, Stock> stock;
	
	@PostConstruct
	private void setupTestData() {
		stock = new HashMap<Integer, Stock>();
	}

	public Map<Integer, Stock> getStock() {
		return stock;
	}
	
	public void addStock(Stock stock) {
		stock.setId(""+stock.hashCode());
		this.stock.put(stock.hashCode(), stock);
	}
}