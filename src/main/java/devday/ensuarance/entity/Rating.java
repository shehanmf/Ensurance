package devday.ensuarance.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name="rating")
@Proxy(lazy=false)
public class Rating {
	@Id
	@GeneratedValue
	private long id;
	
	@ManyToOne
	@JoinColumn(name="factor_id", nullable=false)
	private RatingFactor ratingFactor;
	
	@ManyToOne
	@JoinColumn(name="review_id", nullable=false)
	private Review review;
	
	@Column
	private short value;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public RatingFactor getRatingFactor() {
		return ratingFactor;
	}

	public void setRatingFactor(RatingFactor ratingFactor) {
		this.ratingFactor = ratingFactor;
	}

	public Review getReview() {
		return review;
	}

	public void setReview(Review review) {
		this.review = review;
	}

	public short getValue() {
		return value;
	}

	public void setValue(short value) {
		this.value = value;
	}
	
	
}
