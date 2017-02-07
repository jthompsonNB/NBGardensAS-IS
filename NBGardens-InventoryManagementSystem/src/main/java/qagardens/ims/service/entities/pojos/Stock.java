package qagardens.ims.service.entities.pojos;

import java.util.Date;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import qagardens.ims.service.entities.enums.StockStatus;

import java.time.Instant;

public class Stock implements Comparable<Stock> {
	@NotNull
	private String id;
	@NotNull
	@Size(min=3, max=225)
	private String name;
	@NotNull
	@Enumerated(EnumType.STRING)
	private StockStatus status;
	@Past
	@NotNull
	private Date dateAdded;
	@Min(0)
	@NotNull
	private int level;
	
	public Stock(String name) {
		this.name = name;
		this.status = StockStatus.PROCESSING;
		this.dateAdded = Date.from(Instant.now());
		this.level = 0;
	}
	
	public Stock(String id, String name, StockStatus status, Date dateAdded, int level) {
		this.id = id;
		this.name = name;
		this.status = status;
		this.dateAdded = dateAdded;
		this.level = level;
	}
	
	public Stock() {
		// TODO Auto-generated constructor stub
	}

	public String getId() { return id; }
	public String getName() { return name; }
	public StockStatus getStatus() { return status; }
	public Date getDateAdded() { return dateAdded; }
	public int getLevel() { return level; }

	public void setId(String id) { this.id = id; }
	public void setName(String name) { this.name = name; }
	public void setStatus(StockStatus status) { this.status = status; }
	public void setDateAdded(Date dateAdded) { this.dateAdded = dateAdded; }
	public void setLevel(int level) { this.level = level; }

	@Override
	public int compareTo(Stock stock) {
		return this.id.compareTo(stock.id);
	}
}