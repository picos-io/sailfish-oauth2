package io.picos.oauth2.repository;

import io.picos.oauth2.domain.model.AppRole;
import io.picos.oauth2.domain.model.User;
import io.picos.oauth2.domain.model.UserRoleRelationship;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;


/**
 * @author dz
 */
public interface UserRoleRelationshipRepository extends PagingAndSortingRepository<UserRoleRelationship, String> {

    UserRoleRelationship findById(String id);

    Page<UserRoleRelationship> findByRole(AppRole role, Pageable pageable);

    Page<UserRoleRelationship> findByUser(User user, Pageable pageable);

    List<UserRoleRelationship> findListByUser(User user);

    UserRoleRelationship findByUserAndRole(User user, AppRole role);

    UserRoleRelationship findFirstByRole(AppRole appRole);

}
