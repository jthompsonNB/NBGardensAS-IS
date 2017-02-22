package qagardens.ims.service.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="stockorderlines")
public class OrderLine {
	@NotNull
	@Column(nullable=false)
	private int quantity;
	
	@NotNull
	@Column(nullable=false)
	private float pricePerUnit;
	
	@Column()
	private int received;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="stock_stockID")
	private Stock stock;

	public OrderLine() {}
	
	public OrderLine(int quantity, float pricePerUnit, Stock stock) {
		this.quantity = quantity;
		this.pricePerUnit = pricePerUnit;
		this.stock = stock;
	}

	public int getQuantity() { return quantity; }
	public float getPricePerUnit() { return pricePerUnit; }
	public int getReceived() { return received; }
	public Stock getStock() { return stock; }

	public void setQuantity(int quantity) { this.quantity = quantity; }
	public void setPricePerUnit(float pricePerUnit) { this.pricePerUnit = pricePerUnit; }
	public void setReceived(int received) { this.received = received; }
	public void setStock(Stock stock) { this.stock = stock; }
}