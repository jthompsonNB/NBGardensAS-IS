package qagardens.ims.data.test;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import qagardens.ims.service.entities.pojos.Stock;

@Startup
@Singleton
public class TestData {

	//public static TestData data = new TestData();
	private List<Stock> stock;
	
	@PostConstruct
	private void setupTestData() {
		stock = new ArrayList<Stock>();
	}

	public List<Stock> getStock() {
		return stock;
	}
}