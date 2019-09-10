package com.marco.usersservice.persistence;

import com.marco.usersservice.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(path = "users")
public interface UsersDAO extends PagingAndSortingRepository<User, Long> {

    User findByUserName(String userName);

    @RestResource(path="withEmail")
    User findByEmail(String email);

}
