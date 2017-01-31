package qagardens.ims.service.entities.pojos;

import java.util.Date;

import qagardens.ims.service.entities.enums.StockStatus;

import java.time.Instant;

public class Stock implements Comparable<Stock> {
	private long id;
	private String name;
	private StockStatus status;
	private Date dateAdded;
	private int level;
	
	public Stock(String name) {
		this.name = name;
		this.status = StockStatus.PROCESSING;
		this.dateAdded = Date.from(Instant.now());
		this.level = 0;
	}
	
	public Stock(long id, String name, StockStatus status, Date dateAdded, int level) {
		this.id = id;
		this.name = name;
		this.status = status;
		this.dateAdded = dateAdded;
		this.level = level;
	}
	
	public Stock() {
		// TODO Auto-generated constructor stub
	}

	public long getId() { return id; }
	public String getName() { return name; }
	public StockStatus getStatus() { return status; }
	public Date getDateAdded() { return dateAdded; }
	public int getLevel() { return level; }

	public void setId(long id) { this.id = id; }
	public void setName(String name) { this.name = name; }
	public void setStatus(StockStatus status) { this.status = status; }
	public void setDateAdded(Date dateAdded) { this.dateAdded = dateAdded; }
	public void setLevel(int level) { this.level = level; }

	@Override
	public int compareTo(Stock stock) {
		return (int) (this.id-stock.getId());
	}
}