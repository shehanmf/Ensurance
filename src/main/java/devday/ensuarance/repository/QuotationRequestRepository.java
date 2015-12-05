/**
 * 
 */
package devday.ensuarance.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import devday.ensuarance.entity.QuotationRequest;

/**
 * @author Chamara.Caldera
 *
 */
@Repository
@Qualifier(value = "quatationRequestRepository")
@Transactional
public interface QuotationRequestRepository extends JpaRepository<QuotationRequest, Long>{

	List<QuotationRequest> findByRequestor_Username(String username);
	
	@Query("select distinct req from QuotationRequest req where id not in (select quot.request from Quotation quot where quot.owner.username=:username)")
	List<QuotationRequest> findUnansweredRequestsByAgest(@Param("username") String username);
	
}
