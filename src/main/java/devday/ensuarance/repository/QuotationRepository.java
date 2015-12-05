package devday.ensuarance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import devday.ensuarance.entity.Quotation;

public interface QuotationRepository extends JpaRepository<Quotation, Long> {
	
	List<Quotation> findByOwner_Username(String username);
	
	List<Quotation> findByRequest_Id(String id);
	

}
