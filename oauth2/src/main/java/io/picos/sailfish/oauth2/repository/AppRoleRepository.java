package io.picos.sailfish.oauth2.repository;


import io.picos.sailfish.oauth2.domain.model.AppRole;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author dz
 */
public interface AppRoleRepository extends PagingAndSortingRepository<AppRole, String> {

    AppRole findById(String id);

    AppRole findByCode(String code);

    AppRole findByName(String name);

}