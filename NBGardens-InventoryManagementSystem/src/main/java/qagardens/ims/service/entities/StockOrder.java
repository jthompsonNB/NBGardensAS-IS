package qagardens.ims.service.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import qagardens.ims.service.entities.enums.OrderStatus;

@Entity
@Table(name="stockOrders")
@NamedQueries({
	@NamedQuery(name="StockOrder.FIND_BY_SUPPLIER", query="SELECT so FROM stockOrders so WHERE so.supplier_supplierId = :supplierId"),
	@NamedQuery(name="StockOrder.FIND_BY_OUTSTANDING", query="SELECT so FROM stockOrders so WHERE so.dateReceived IS NULL"),
	@NamedQuery(name="StockOrder.FIND_BY_DATEPLACED", query="SELECT so FROM stockOrders so WHERE so.dateplaced = :supplierId")
})
public class StockOrder {
	public static final String FIND_BY_SUPPLIER = "StockOrder.findBySupplier";
	public static final String FIND_BY_OUTSTANDING = "StockOrder.findByOutstanding";
	public static final String FIND_BY_DATEPLACED = "StockOrder.findByDatePlaced";
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="stockorderId", nullable=false)
	private String id;
	
	@Past
	@Column(nullable=false)
	@Temporal(TemporalType.DATE)
	private Date datePlaced;
	
	@Column(nullable=true)
	@Temporal(TemporalType.DATE)
	private Date dateReceived;
	
	@Column(nullable=false, name="orderStatus")
	@Enumerated(EnumType.STRING)
	private OrderStatus status;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="supplier_supplierId")
	private Supplier supplier;
	
	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="stockOrders_stockOrderId")
	private List<OrderLine> orderLines;	
	
	public StockOrder() {}

	public StockOrder(String id, Date datePlaced, Supplier supplier, List<OrderLine> orderLines) {
		this.id = id;
		this.datePlaced = datePlaced;
		this.supplier = supplier;
		this.orderLines = orderLines;
		status = OrderStatus.CREATING;
	}

	public String getId() { return id; }
	public Date getDatePlaced() { return datePlaced; }
	public Date getDateReceived() { return dateReceived; }
	public Supplier getSupplier() { return supplier; }
	public OrderStatus getStatus() { return status; }
	public List<OrderLine> getOrderLines() { return orderLines; }

	public void setId(String id) { this.id = id; }
	public void setDatePlaced(Date datePlaced) { this.datePlaced = datePlaced; }
	public void setDateReceived(Date dateReceived) { this.dateReceived = dateReceived; }
	public void setSupplier(Supplier supplier) { this.supplier = supplier; }
	public void setStatus(OrderStatus status) { this.status = status; }
	public void setOrderLines(List<OrderLine> orderLines) { this.orderLines = orderLines; }
}