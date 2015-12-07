package devday.ensuarance.dto;

import java.util.Map;

public class RatingSummary {
	private Long companyId;

	private Double totalRating;

	private Map<Long, Double> factorWiseRatings;
	
	private Long totalNoOfReviews;

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public Double getTatalRating() {
		return totalRating;
	}

	public void setTotalRating(Double tatalRating) {
		this.totalRating = tatalRating;
	}

	public Map<Long, Double> getFactorWiseRatings() {
		return factorWiseRatings;
	}

	public void setFactorWiseRatings(Map<Long, Double> factorWiseRatings) {
		this.factorWiseRatings = factorWiseRatings;
	}

	public Long getTotalNoOfReviews() {
		return totalNoOfReviews;
	}

	public void setTotalNoOfReviews(Long totalNoOfReviews) {
		this.totalNoOfReviews = totalNoOfReviews;
	}
}
