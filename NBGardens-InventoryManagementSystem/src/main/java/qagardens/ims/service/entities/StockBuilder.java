package qagardens.ims.service.entities;

import java.time.Instant;
import java.util.Date;

import qagardens.ims.service.entities.enums.StockStatus;
import qagardens.ims.service.entities.pojos.Stock;

public class StockBuilder {
	private long id;
	private String name;
	private StockStatus status = StockStatus.PROCESSING;
	private Date dateAdded = Date.from(Instant.now());
	private int level = 0;
	
	public StockBuilder(){}
	
	public Stock createStock(){
		return new Stock(id, name, status, dateAdded, level);
	}
	
	public StockBuilder id(long id) {
		this.id = id;
		return this;
	}
	
	public StockBuilder name(String name) {
		this.name = name;
		return this;
	}
	
	public StockBuilder status(StockStatus status) {
		this.status = status;
		return this;
	}
	
	public StockBuilder dateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
		return this;
	}
	
	public StockBuilder level(int level) {
		this.level = level;
		return this;
	}
}