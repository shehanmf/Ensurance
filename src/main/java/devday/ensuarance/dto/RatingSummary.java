package devday.ensuarance.dto;

import java.util.Map;

public class RatingSummary {
	private Long companyId;

	private Double tatalRating;

	private Map<Long, Double> factorWiseRatings;

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public Double getTatalRating() {
		return tatalRating;
	}

	public void setTatalRating(Double tatalRating) {
		this.tatalRating = tatalRating;
	}

	public Map<Long, Double> getFactorWiseRatings() {
		return factorWiseRatings;
	}

	public void setFactorWiseRatings(Map<Long, Double> factorWiseRatings) {
		this.factorWiseRatings = factorWiseRatings;
	}
}
