package devday.ensuarance.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "quotation_requests")
@Proxy(lazy=false)
public class QuotationRequest {
	
	@Id
	@GeneratedValue
	private long id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="vehicle_category_id", nullable=false)
	private VehicleCategory vehicleCategory;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="insuarnce_type_id", nullable=false)
	private InsuaranceType insuaranceType;

	@Column
	private int year;

	@Column
	private int value;
	
	@Column
	private String description;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="requestor_id", nullable=false)
	private User requestor;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date created;

	@OneToMany(fetch = FetchType.EAGER)
	private List<Quotation> quotations;
	
	public QuotationRequest()
	{
		
	}
	
	public InsuaranceType getInsuaranceType() {
		return insuaranceType;
	}

	public void setInsuaranceType(InsuaranceType insuaranceType) {
		this.insuaranceType = insuaranceType;
	}

	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}

	public VehicleCategory getVehicleCategory() {
		return vehicleCategory;
	}

	public void setVehicleCategory(VehicleCategory vehicleCategory) {
		this.vehicleCategory = vehicleCategory;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public User getRequestor() {
		return requestor;
	}

	public void setRequestor(User requestor) {
		this.requestor = requestor;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public List<Quotation> getQuotations() {
		return quotations;
	}

	public void setQuotations(List<Quotation> quotations) {
		this.quotations = quotations;
	}
	
	

}
