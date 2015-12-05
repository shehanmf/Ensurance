package devday.ensuarance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import devday.ensuarance.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {

}
