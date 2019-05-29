package io.picos.oauth2.repository;

import io.picos.oauth2.domain.model.OAuth2Client;
import io.picos.oauth2.domain.model.User;
import io.picos.oauth2.repository.custom.UserRepositoryCustom;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author dz
 */
public interface OAuth2ClientRepository extends PagingAndSortingRepository<OAuth2Client, String> {

    OAuth2Client findById(String id);

}