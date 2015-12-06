package devday.ensuarance.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import devday.ensuarance.entity.Company;
import devday.ensuarance.entity.QuotationRequest;
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
	public long saveReview(Review review)
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User commentor = userRepositiry.findByUsername(auth.getName());
		Company company = companyRepo.findOne(review.getCompany().getId());
		review.setCommentor(commentor);
		review.setCompany(company);
		return reviewRepo.save(review).getId();
	}
}
