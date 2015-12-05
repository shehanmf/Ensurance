package devday.ensuarance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import devday.ensuarance.entity.RatingFactor;

public interface RatingFactorRepository extends JpaRepository<RatingFactor, Long> {

}
