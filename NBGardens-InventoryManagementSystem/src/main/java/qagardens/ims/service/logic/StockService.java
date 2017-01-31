package qagardens.ims.service.logic;

import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.swing.SortOrder;

import qagardens.common.annotations.Loggable;
import qagardens.common.annotations.MethodAuthor;
import qagardens.ims.data.test.TestData;
import qagardens.ims.service.entities.StockBuilder;
import qagardens.ims.service.entities.pojos.Stock;

//imports

/**
 * This class is used to perform service stock.
 * This includes the addition, removal and general managing of stock.
 * 
 * @author James Thompson
 *
 */
@Loggable
@Stateless
public class StockService {
	@Inject private Logger logger;
	@Inject
	private TestData testData;
	
	/**
	 * Used to retrieve the list of stock in a specified order
	 * @param order - the Order to sort the list by.
	 * @return - The List of stock in the order specified.
	 */
	@MethodAuthor("James Thompson")
	public List<Stock> retreiveStockList(SortOrder order) {
		//List<Stock> stockList = TestData.data.getStock();
		List<Stock> stockList = testData.getStock();
		switch(order) {
			case ASCENDING :
				logger.finest("Returning the StockList in Acending Order");
				Collections.sort(stockList);
				break;
			case DESCENDING :
				logger.finest("Returning the StockList in Decending Order");
				Collections.sort(stockList);
				Collections.reverse(stockList);
				break;
			case UNSORTED :
				logger.finest("Returning the StockList without Sorting");
				break;
		}
		try {
			throw new Exception();
		} catch (Exception e) {
			logger.severe("exception occured: " + e.getMessage());
			e.printStackTrace();
		}
		return stockList;
	}
	
	/**
	 * Used to retrieve the list of stock in a specified order
	 * @param order - the Order to sort the list by.
	 * @return - The List of stock in the order specified.
	 */
	@MethodAuthor("James Thompson")
	public List<Stock> retreiveStockList() {
		return null;
	}
	
	@MethodAuthor("James Thompson")
	public Stock addStock(String name) {
		Stock stock = new StockBuilder().name(name).createStock();
		return stock;
	}
}