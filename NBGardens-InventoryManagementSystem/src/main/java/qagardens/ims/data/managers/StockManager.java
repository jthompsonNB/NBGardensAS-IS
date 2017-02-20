package qagardens.ims.data.managers;

import java.util.List;

import qagardens.ims.service.entities.Stock;

public interface StockManager {
	public Stock persistStock(Stock stock);
	public Stock findById(String id);
	public List<Stock> findByName(String name);
	public List<Stock> findAll();
	public void updateStock(Stock stock);
	public void deleteStock(Stock stock);
}