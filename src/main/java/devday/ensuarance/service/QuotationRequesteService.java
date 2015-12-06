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
import devday.ensuarance.repository.QuotationRequestRepository;
import devday.ensuarance.repository.UserRepository;

@Component
@Path("/quotationrequesteservice")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class QuotationRequesteService{
	
	@Autowired
	private QuotationRequestRepository quotationRequestRepository;
	
	@Autowired
	private UserRepository userRepositiry;
	
	@POST
	@Path("/requestquotations")
	public long createQuotationRequest(QuotationRequest request)
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User requestor = userRepositiry.findByUsername(auth.getName());
		request.setRequestor(requestor);
		return quotationRequestRepository.save(request).getId();
	}
	
	@GET
	@Path("/listall")
	public List<QuotationRequest> listAll()
	{
		return quotationRequestRepository.findAll();
	}

	@GET
	@Path("/getrequestbyid")
	public QuotationRequest getQuotationRequestById(@QueryParam("id") long id) {
		QuotationRequest q= quotationRequestRepository.getOne(id);
		return q;
	}

	@GET
	@Path("/findbyrequestor")
	public List<QuotationRequest> findQuotationRequestByRequestor(@QueryParam("username") String username) {
		return quotationRequestRepository.findByRequestor_Username(username);
	}
	
	/**
	 * Get the requests i have requested
	 * 
	 * @return
	 */
	@GET
	@Path("/getmyrequests")
	public List<QuotationRequest> getMyRequests()
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return findQuotationRequestByRequestor(auth.getName());
	}
	
	
	
	/**
	 * Get unanswered request for current user
	 * Agent functionality
	 * 
	 * @return
	 */
	@Path("/getnewrequeststome")
	@GET
	public List<QuotationRequest> getNewQuotationRequestsForCurrentUser()
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return quotationRequestRepository.findUnansweredRequestsByAgest(auth.getName());
	}

}
