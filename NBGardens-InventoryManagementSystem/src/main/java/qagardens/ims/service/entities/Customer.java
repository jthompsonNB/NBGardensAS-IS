package qagardens.ims.service.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="customers")
public class Customer {
	@NotNull
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(nullable=false, unique=true)
	private String id;
	@NotNull
	@Column(name="customer_Name", length=225, nullable=false)
	private String name;
	@NotNull
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="address_addressId", nullable=false)
	private Address address;
	@ManyToMany
	@JoinTable(name="wishlist", joinColumns=@JoinColumn(name="customers_customerId"),inverseJoinColumns=@JoinColumn(name="stocks_stockId"))
	private List<Stock> wishList;
}