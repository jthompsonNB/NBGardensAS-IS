package com.qac.oc.entities;
import static javax.persistence.GenerationType.*;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * This represents the data associated with a customer.
 * 
 * @author James Thompson
 *
 */
@Entity
@Table(name="customers")
@NamedQuery(name="findByEmail", query="SELECT c FROM customers c WHERE c.email=:email")
public class Customer {
	@Id
	@Column(name="id", nullable=false, unique=true)
	@GeneratedValue(strategy=IDENTITY)
	private long id;
	@Column(nullable=false, length=225)
	@Size(max=225)
	@NotNull
	private String firstName;
	@Column(nullable=false, length=225)
	@Size(max=225)
	@NotNull
	private String lastName;
	@Column(nullable=false, length=225)
	@Size(max=225)
	@NotNull
	private String email;
	@Column(nullable=false, length=225)
	@Size(max=225)
	@NotNull
	private String password;
	@Column(nullable=false)
	@NotNull
	private LocalDate dateAdded;
	@ManyToOne
	@JoinColumn(name="addresses_id", nullable=false)
	@NotNull
	private Address address;
	@ManyToMany
	@JoinTable(name="wishlist", joinColumns=@JoinColumn(name="customers_id", referencedColumnName="id"), inverseJoinColumns=@JoinColumn(name="stock_id", referencedColumnName="id"))
	private List<Stock> wishlist;
	
	

	public Customer() { }
	
	public Customer(String firstName, String lastname, String email, String password, Address address, LocalDate dateAdded) {
		this.firstName = firstName;
		this.lastName = lastname;
		this.email = email;
		this.password = password;
		this.address = address;
		this.dateAdded = dateAdded;
	}
	
	public Customer(long id, String firstName, String lastname, String email, String password, Address address, LocalDate dateAdded) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastname;
		this.email = email;
		this.password = password;
		this.address = address;
		this.dateAdded = dateAdded;
	}

	public long getId() { return id; }
	public String getFirstName() { return firstName; }
	public String getLastName() { return lastName; }
	public String getEmail() { return email; }
	public String getPassword() { return password; }
	public Address getAddress() { return address; }
	public LocalDate getDateAdded() { return dateAdded; }
	public List<Stock> getWishlist() { return wishlist; }

	public void setId(int id) { this.id = id; }
	public void setFirstName(String firstName) { this.firstName = firstName; }
	public void setLastName(String lastname) { this.lastName = lastname; }
	public void setEmail(String email) { this.email = email; }
	public void setPassword(String password) { this.password = password; }
	public void setAddress(Address address) { this.address = address; }
	public void setDateAdded(LocalDate dateAdded) { this.dateAdded = dateAdded; }
	public void setWishlist(List<Stock> wishlist) { this.wishlist = wishlist; }
}