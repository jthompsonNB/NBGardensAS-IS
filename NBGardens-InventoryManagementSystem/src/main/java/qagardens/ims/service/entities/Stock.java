package qagardens.ims.service.entities;

import java.util.Date;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import qagardens.ims.service.entities.enums.StockStatus;

import java.time.Instant;

@Entity
@Table
@Cacheable(true)
@NamedQueries({
	@NamedQuery(name="Stock.FIND_BY_NAME", query="SELECT s FROM stock s WHERE s.name = :name"),
	@NamedQuery(name="Stock.FIND_ALL", query="SELECT s FROM stock s")
})
public class Stock implements Comparable<Stock> {
	public static final String FIND_BY_NAME = "Stock.findByName";
	public static final String FIND_ALL = "Stock.findAll";
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