package devday.ensuarance.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="quotation_items")
public class QuotationItem {

	@Id
	@GeneratedValue
	private long id;
	
	@ManyToOne
	@JoinColumn(name="type_id", nullable=false)
	private QuotationItemType type;
	
	@Column
	private double price;
	
	@ManyToOne
	@JoinColumn(name="quotation_id", nullable=false)
	private Quotation quotation;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public QuotationItemType getType() {
		return type;
	}

	public void setType(QuotationItemType type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Quotation getQuotation() {
		return quotation;
	}

	public void setQuotation(Quotation quotation) {
		this.quotation = quotation;
	}
	
}
