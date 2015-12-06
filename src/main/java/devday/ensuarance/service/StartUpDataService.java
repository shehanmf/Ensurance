package devday.ensuarance.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import devday.ensuarance.entity.Company;
import devday.ensuarance.entity.InsuaranceType;
import devday.ensuarance.entity.Quotation;
import devday.ensuarance.entity.QuotationRequest;
import devday.ensuarance.entity.Rating;
import devday.ensuarance.entity.RatingFactor;
import devday.ensuarance.entity.Review;
import devday.ensuarance.entity.User;
import devday.ensuarance.entity.VehicleCategory;
import devday.ensuarance.repository.CompanyRepository;
import devday.ensuarance.repository.InsuaranceTypeRespository;
import devday.ensuarance.repository.QuotationRepository;
import devday.ensuarance.repository.QuotationRequestRepository;
import devday.ensuarance.repository.RatingFactorRepository;
import devday.ensuarance.repository.ReviewRepository;
import devday.ensuarance.repository.UserRepository;
import devday.ensuarance.repository.VehicleCategoryRepository;

/**
 * Created by Shehan on 11/22/2015.
 */
@Service
public class StartUpDataService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private VehicleCategoryRepository vehicleCategoryRepository;

	@Autowired
	private InsuaranceTypeRespository insuaranceTypeRespository;

	@Autowired
	private QuotationRequestRepository qReqRepo;

	@Autowired
	private QuotationRepository qRepo;

	@Autowired
	private RatingFactorRepository factorRepo;
	@Autowired
	private CompanyRepository companyRepo;

	@Autowired
	private ReviewRepository reviewRepo;

	public void initiateStartUpData() {
		User user = userRepository.findByUsername("Shehan");
		if (user == null) {
			user = User.createUser("Shehan", "shehan_mf@yahoo.com", "Logos321");
			user = userRepository.save(user);
		}

		User userPr = userRepository.findByUsername("Priyal");
		if (userPr == null) {
			userPr = User.createUser("Priyal", "priyal85@gmail.com", "abc123");
			userPr = userRepository.save(userPr);
		}
		//
		System.out.println(userPr.getUsername() + "   " + userPr.getEmail());

		createVehiclecategories();
		createInsuaranceTypes();
		createInsuranceCompanies();
		createRatingFactores();
		createReviews();

		// dummy
		QuotationRequest req1 = new QuotationRequest();
		req1.setDescription("desc1");
		InsuaranceType t = new InsuaranceType();
		t.setId(1);
		req1.setInsuaranceType(t);
		VehicleCategory cat = new VehicleCategory();
		cat.setId(1);
		req1.setVehicleCategory(cat);
		req1.setRequestor(user);
		req1.setValue(100);
		req1.setYear(2000);

		User user1 = User.createUser("Shehan1", "shehan1_mf@yahoo.com", "Logos321");
		//
		user1 = userRepository.save(user1);

		QuotationRequest req2 = new QuotationRequest();
		req2.setDescription("desc2");
		req2.setInsuaranceType(t);
		req2.setVehicleCategory(cat);
		req2.setRequestor(user1);
		req2.setValue(1001);
		req2.setYear(2001);

		req1 = qReqRepo.save(req1);
		req2 = qReqRepo.save(req2);

		Quotation quot = new Quotation();
		quot.setBasicPremium(200);
		quot.setDescription("desc");
		quot.setOwner(userPr);
		quot.setRequest(req2);
		// qRepo.save(quot);

	}

	private void createReviews() {
		List<Company> allCompanies = companyRepo.findAll();
		List<RatingFactor> allFactors = factorRepo.findAll();
		User userSh = userRepository.findByUsername("Shehan");
		User userPr = userRepository.findByUsername("Priyal");
		Review review1 = new Review();
		review1.setCommentor(userSh);
		review1.setCompany(allCompanies.get(0));
		review1.setCreate(new Date());
		review1.setReviewTitle("Satisfying");
		review1.setReviewComment("Satisfying Service. Recommend for others.");
		List<Rating> ratings1 = new ArrayList<Rating>();
		for (RatingFactor ratingFactor : allFactors) {
			Rating rating = new Rating();
			rating.setRatingFactor(ratingFactor);
			rating.setValue(Long.valueOf(Math.round(Math.random() * 5)).shortValue());
			rating.setReview(review1);
			ratings1.add(rating);
		}
		review1.setRatings(ratings1);

		Review review2 = new Review();
		review2.setCommentor(userPr);
		review2.setCompany(allCompanies.get(1));
		review2.setCreate(new Date());
		review2.setReviewTitle("Average");
		review2.setReviewComment("Average Service.");
		List<Rating> ratings2 = new ArrayList<Rating>();
		for (RatingFactor ratingFactor : allFactors) {
			Rating rating = new Rating();
			rating.setRatingFactor(ratingFactor);
			rating.setValue(Long.valueOf(Math.round(Math.random() * 5)).shortValue());
			rating.setReview(review2);
			ratings2.add(rating);
		}
		review2.setRatings(ratings2);

		reviewRepo.save(Arrays.asList(review1, review2));
	}

	public void createVehiclecategories() {
		System.out.println("Start creating vehical categories");

		vehicleCategoryRepository.deleteAllInBatch();

		VehicleCategory carCat = VehicleCategory.createInstance("Car");
		VehicleCategory suvCat = VehicleCategory.createInstance("SUV");
		VehicleCategory vanCat = VehicleCategory.createInstance("Van");
		VehicleCategory bicycleCat = VehicleCategory.createInstance("Bicycle");

		List<VehicleCategory> saved = vehicleCategoryRepository
				.save(Arrays.asList(new VehicleCategory[] { carCat, suvCat, vanCat, bicycleCat }));

		System.out.println("Created vehicle categories, count=" + saved.size());

	}

	public void createInsuaranceTypes() {
		System.out.println("Start creating insuarance types");

		insuaranceTypeRespository.deleteAllInBatch();

		InsuaranceType thirdParty = InsuaranceType.createInstance("Third party");
		InsuaranceType fullOption = InsuaranceType.createInstance("Full Option");

		List<InsuaranceType> saved = insuaranceTypeRespository
				.save(Arrays.asList(new InsuaranceType[] { thirdParty, fullOption }));

		System.out.println("Created insuarance types, count=" + saved.size());

	}

	private void createRatingFactores() {
		List<RatingFactor> factors = new ArrayList<RatingFactor>();
		RatingFactor factor1 = new RatingFactor();
		factor1.setDescription("How quickly the agent arrived?");
		factors.add(factor1);
		RatingFactor factor2 = new RatingFactor();
		factor2.setDescription("Anual Premium Amount");
		factors.add(factor2);
		RatingFactor factor3 = new RatingFactor();
		factor3.setDescription("How soon the claim was processed?");
		factors.add(factor3);
		RatingFactor factor4 = new RatingFactor();
		factor4.setDescription("How helpful was the customer care centre/hotline");
		factors.add(factor4);
		RatingFactor factor5 = new RatingFactor();
		factor5.setDescription("Overall satisfaction about the company's service");
		factors.add(factor5);
		factorRepo.save(factors);

	}

	private void createInsuranceCompanies() {

		List<Company> companies = new ArrayList<Company>();
		Company company1 = new Company();
		company1.setName("Janashakthi");
		companies.add(company1);
		Company company2 = new Company();
		company2.setName("Sri Lanka Insurance");
		companies.add(company2);
		Company company3 = new Company();
		company3.setName("Ceylinco");
		companies.add(company3);
		companyRepo.save(companies);
	}
}
