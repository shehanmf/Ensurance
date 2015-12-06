package devday.ensuarance.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import devday.ensuarance.dto.RatingSummary;
import devday.ensuarance.entity.Company;
import devday.ensuarance.entity.Rating;
import devday.ensuarance.entity.Review;
import devday.ensuarance.entity.User;
import devday.ensuarance.repository.CompanyRepository;
import devday.ensuarance.repository.RatingFactorRepository;
import devday.ensuarance.repository.ReviewRepository;
import devday.ensuarance.repository.UserRepository;

@Component
@Path("/reviewservice")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ReviewService {
	@Autowired
	private ReviewRepository reviewRepo;
	@Autowired
	private RatingFactorRepository factorRepo;
	@Autowired
	private CompanyRepository companyRepo;

	@Autowired
	private UserRepository userRepositiry;

	@POST
	@Path("/savereview")
	public long saveReview(Review review) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User commentor = userRepositiry.findByUsername(auth.getName());
		Company company = companyRepo.findOne(review.getCompany().getId());
		review.setCommentor(commentor);
		review.setCompany(company);
		return reviewRepo.save(review).getId();
	}

	@GET
	@Path("/allreviews")
	public List<Review> getAllReviews() {
		return reviewRepo.findAll();
	}

	@GET
	@Path("/reviewsbyusers")
	public List<Review> getReviewsByUserName(@QueryParam("username") String username) {
		return reviewRepo.findByCommentor_Username(username);
	}

	@GET
	@Path("/reviewsbycompany")
	public List<Review> getReviewsByCompany(@QueryParam("id") Long companyId) {
		return reviewRepo.findByCompany_Id(companyId);
	}

	@GET
	@Path("/ratingsummary")
	public RatingSummary getRatingSummary(@QueryParam("id") Long companyId) {
		RatingSummary summary = createRatingSummary(companyId);
		return summary;
	}

	private RatingSummary createRatingSummary(Long companyId) {
		List<Review> reviews = reviewRepo.findByCompany_Id(companyId);
		Map<Long, List<Short>> factorToRatingMap = new HashMap<Long, List<Short>>();
		for (Review review : reviews) {
			for (Rating rating : review.getRatings()) {
				Long factorId = rating.getRatingFactor().getId();
				List<Short> values = factorToRatingMap.get(factorId);
				if (values == null) {
					values = new ArrayList<Short>();
					factorToRatingMap.put(factorId, values);
				}
				values.add(rating.getValue());
			}
		}
		Map<Long, Double> factorToAvgRatingMap = new HashMap<Long, Double>();
		double overallSum = 0;
		for (Entry<Long, List<Short>> entry : factorToRatingMap.entrySet()) {
			double sum = 0;
			List<Short> values = entry.getValue();
			for (Short value : values) {
				sum += value;
			}
			double avg = values.isEmpty() ? 0 : sum / values.size();
			overallSum += sum;
			factorToAvgRatingMap.put(entry.getKey(), Math.round(avg * 100.0) / 100.0);
		}
		double overallRating = factorToRatingMap.isEmpty() ? 0
				: Math.round((overallSum / factorToRatingMap.size()) * 100.0) / 100;
		RatingSummary summary = new RatingSummary();
		summary.setCompanyId(companyId);
		summary.setTotalNoOfReviews((long) reviews.size());
		summary.setFactorWiseRatings(factorToAvgRatingMap);
		summary.setTotalRating(overallRating);
		return summary;
	}
}
