package qagardens.ims.service.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.qac.util.validation.Email;

@Entity
@Table(name="suppliers")
public class Supplier {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="supplierId")
	private String id;
	
	@NotNull
	@Size(max=100)
	@Column(length=100, nullable=false)
	private String name;
	
	@NotNull
	@Size(max=11)
	@Column(length=11, nullable=false)
	private String phone;
	
	@NotNull
	@Email
	@Column(length=225, nullable=false)
	private String email;
}