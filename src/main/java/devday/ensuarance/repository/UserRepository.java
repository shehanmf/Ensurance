package devday.ensuarance.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import devday.ensuarance.entity.User;

/**
 * Created by Shehan on 11/22/2015.
 */
@Repository
@Qualifier(value = "userRepository")
public interface UserRepository extends CrudRepository<User, Long> {
    public User findByUsername(String username);
}