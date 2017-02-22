package qagardens.ims.service.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SupplierStock implements Serializable {
	private static final long serialVersionUID = 326757013205075807L;
	@Id private String id;
	private String supplier;
	private String stockItem;
	private float price;
	private float pricePerTen;

	public String getId() { return id; }
	public String getSupplier() { return supplier; }
	public String getStockItem() { return stockItem; }
	public float getPrice() { return price; }
	public float getPricePerTen() { return pricePerTen; }

	public void setId(String id) { this.id = id; }
	public void setSupplier(String supplier) { this.supplier = supplier; }
	public void setStockItem(String stockItem) { this.stockItem = stockItem; }
	public void setPrice(float price) { this.price = price; }
	public void setPricePerTen(float pricePerTen) { this.pricePerTen = pricePerTen; }
}