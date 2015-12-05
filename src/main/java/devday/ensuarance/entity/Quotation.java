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
@Table(name="quotations")
@Proxy(lazy=false)
public class Quotation {
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column
	private double basicPremium;
	
	@OneToMany(fetch=FetchType.EAGER)
	private List<QuotationItem> quotationItems;
	
	@Column
	private String description;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="owner_id", nullable=false)
	private User owner;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="request_id", nullable=false)
	private QuotationRequest request;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date create;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getBasicPremium() {
		return basicPremium;
	}

	public void setBasicPremium(double basicPremium) {
		this.basicPremium = basicPremium;
	}

	public List<QuotationItem> getQuotationItems() {
		return quotationItems;
	}

	public void setQuotationItems(List<QuotationItem> quotationItems) {
		this.quotationItems = quotationItems;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public QuotationRequest getRequest() {
		return request;
	}

	public void setRequest(QuotationRequest request) {
		this.request = request;
	}
	
	
}
