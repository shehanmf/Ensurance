/**
 * 
 */
package devday.ensuarance.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import devday.ensuarance.entity.Company;
import devday.ensuarance.entity.InsuaranceType;
import devday.ensuarance.entity.RatingFactor;
import devday.ensuarance.entity.VehicleCategory;
import devday.ensuarance.repository.CompanyRepository;
import devday.ensuarance.repository.InsuaranceTypeRespository;
import devday.ensuarance.repository.RatingFactorRepository;
import devday.ensuarance.repository.VehicleCategoryRepository;

/**
 * @author Chamara.Caldera
 *
 */
@Component
@Path("/masterdata")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MasterDataServices {
	
	@Autowired
	private VehicleCategoryRepository vehicleCategoryRepository;
	
	@Autowired
    private InsuaranceTypeRespository insuaranceTypeRespository;
	
	@Autowired
	private RatingFactorRepository factorRepo;
	@Autowired
	private CompanyRepository companyRepo;

	@GET
	@Path("/listvehiclecategories")
	public List<VehicleCategory> getVehicalCategories()
	{
		return vehicleCategoryRepository.findAll();
	}
	
	@GET
	@Path("/listinsuarancetypes")
	public List<InsuaranceType> getInsuranceTypes()
	{
		return insuaranceTypeRespository.findAll();
	}

	@GET
	@Path("/listratingfactors")
	public List<RatingFactor> getAllRatingFactors() {
		return factorRepo.findAll();
	}

	@GET
	@Path("/listcompanies")
	public List<Company> getAllCompanies() {
		return companyRepo.findAll();
	}
	
}
