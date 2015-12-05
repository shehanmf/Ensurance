package devday.ensuarance.service;

import java.util.List;

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

import devday.ensuarance.entity.Quotation;
import devday.ensuarance.entity.QuotationRequest;
import devday.ensuarance.entity.User;
import devday.ensuarance.repository.QuotationRepository;
import devday.ensuarance.repository.QuotationRequestRepository;
import devday.ensuarance.repository.UserRepository;

@Component
@Path("/quotationservice")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class QuotationService {
	
	@Autowired
	private QuotationRepository quotationRepository;
		
	@Autowired
	private UserRepository userRepositiry;
	
	@Path("/submitQuotation")
	@POST
	public long submitQuotation(Quotation quotation)
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User owner = userRepositiry.findByUsername(auth.getName());
		quotation.setOwner(owner);
		return quotationRepository.save(quotation).getId();
	}
	
	@GET
	@Path("/listall")
	public List<Quotation> listAll()
	{
		return quotationRepository.findAll();
	}
	
	@Path("/getbyid")
	@GET
	public Quotation getById(@QueryParam("id") long id)
	{
		return quotationRepository.getOne(id);
	}
	
	/**
	 * Get all quotations i have submitted
	 * Agent
	 * 
	 * @return
	 */
	@Path("/getMyQuotations")
	@GET
	public List<Quotation> getMyQuotations()
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return quotationRepository.findByOwner_Username(auth.getName());
	}
	
	/**
	 * Get all quotations for a given request
	 * 
	 * @param reqId
	 * @return
	 */
	@Path("/getbyrequest")
	@GET
	public List<Quotation> getQuotationsByRequest(@QueryParam("reqId") String reqId)
	{
		return quotationRepository.findByRequest_Id(reqId);
	}

}
