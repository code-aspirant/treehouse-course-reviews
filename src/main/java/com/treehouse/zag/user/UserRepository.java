package com.treehouse.zag.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created @author sobchak on 6/25/17.
 */
@RepositoryRestResource(exported = false) // Hides the repo
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
