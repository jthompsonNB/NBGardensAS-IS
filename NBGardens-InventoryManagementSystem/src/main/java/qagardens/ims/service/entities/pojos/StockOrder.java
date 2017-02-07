package qagardens.ims.service.entities.pojos;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="stockOrders")
public class StockOrder {
	@Id
	@Column(nullable=false)
	private long id;
	@Column(nullable=false)
	@Temporal(TemporalType.DATE)
	private Date datePlaced;
	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="stockOrders_stockOrderId")
	private List<OrderLine> orderLines;
	
}