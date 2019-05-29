package io.picos.oauth2.repository;

import io.picos.oauth2.domain.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author dz
 */
public interface UserRepository extends PagingAndSortingRepository<User, String> {

    User findById(String id);

    User findByUsername(String username);

}