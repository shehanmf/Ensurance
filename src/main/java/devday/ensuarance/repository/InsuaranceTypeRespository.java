/**
 * 
 */
package devday.ensuarance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import devday.ensuarance.entity.InsuaranceType;

/**
 * @author Chamara.Caldera
 *
 */
@Repository("insuaranceTypeRespository")
public interface InsuaranceTypeRespository extends JpaRepository<InsuaranceType, Long>{

}
