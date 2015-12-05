package devday.ensuarance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import devday.ensuarance.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
	List<Review> findByCompany_Id(Long companyId);

	List<Review> findByCommentor_Username(String username);
}
