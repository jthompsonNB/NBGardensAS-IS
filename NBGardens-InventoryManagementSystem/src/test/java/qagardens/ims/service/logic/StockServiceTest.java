package qagardens.ims.service.logic;

import static org.junit.Assert.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.SortOrder;

import org.junit.Before;
import org.junit.Test;

import qagardens.ims.service.entities.Stock;
import qagardens.ims.service.entities.enums.StockStatus;

/**
 * Tests the qagardens.ims.service.logic.StockService class
 * @author James Thompson
 */
public class StockServiceTest {
	private StockService stockService;
	
	@Before
	public void setUp() throws Exception {
		stockService = new StockService();
	}

	@Test
	public void testRetreiveStockList() {
		assertEquals(new ArrayList<Stock>().getClass(), stockService.retreiveStockList(SortOrder.UNSORTED).getClass());
	}

	@Test
	public void testAddStock() {
		assertEquals("Did not correctly add a new stock line" , new Stock("addStockTest"), stockService.addStock("addStockTest"));
		assertNotEquals("Incorrectly assigned the Stock ID",new Stock("0", "addStockTest", StockStatus.PROCESSING, Date.from(Instant.now()), 0), stockService.addStock("addStockTest"));
	}
}