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

import devday.ensuarance.entity.InsuaranceType;
import devday.ensuarance.entity.VehicleCategory;
import devday.ensuarance.repository.InsuaranceTypeRespository;
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
	
}
