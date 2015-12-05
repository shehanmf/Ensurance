/**
 * 
 */
package devday.ensuarance.repository;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import devday.ensuarance.entity.VehicleCategory;

/**
 * @author Chamara.Caldera
 *
 */
@Repository
@Qualifier(value="vehicleCategoryRepository")
@Transactional
public interface VehicleCategoryRepository extends JpaRepository<VehicleCategory, Long>{

}
