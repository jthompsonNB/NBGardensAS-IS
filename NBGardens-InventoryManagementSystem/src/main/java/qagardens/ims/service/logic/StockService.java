package qagardens.ims.service.logic;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.swing.SortOrder;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidationException;
import javax.validation.Validator;

import qagardens.common.annotations.Loggable;
import qagardens.common.annotations.MethodAuthor;
import qagardens.ims.data.managers.StockManager;
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
	private StockManager stockManager;
	
	/**
	 * Used to retrieve the list of stock in a specified order
	 * @param order - the Order to sort the list by.
	 * @return - The List of stock in the order specified.
	 */
	@MethodAuthor("James Thompson")
	public List<Stock> retreiveStockList(SortOrder order) {
		//List<Stock> stockList = TestData.data.getStock();
		List<Stock> stockList = stockManager.findAll();
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
	public Stock addStock(String name) throws ValidationException {
		Stock stock = new Stock(name);
		if(Validation.buildDefaultValidatorFactory().getValidator().validate(stock).isEmpty()) {
			//Add Stock to datastore
			return stock;
		}
		logger.info("Invalid Stock Creation");
		throw new ValidationException();
	}

	public Stock addStock(Stock stock) throws ValidationException {
		if(Validation.buildDefaultValidatorFactory().getValidator().validate(stock).isEmpty()) {
			//Add Stock to datastore
			return stock;
		}
		logger.info("Invalid Stock Creation");
		throw new ValidationException();
	}

	public Stock retreiveStock(String id) {
		if(id.matches("[0-9]")){
			long stockId = Long.parseLong(id);
			for(Stock stock : testData.getStock())
				if(stock.getId() == stockId)
					return stock;
			return null;
		}
		return null;
	}
}