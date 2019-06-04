package io.picos.sailfish.oauth2.repository;

import io.picos.sailfish.oauth2.domain.model.OAuth2Client;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author dz
 */
public interface OAuth2ClientRepository extends PagingAndSortingRepository<OAuth2Client, String> {

    OAuth2Client findById(String id);

    OAuth2Client findByClientId(String clientId);

}