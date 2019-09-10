package com.marco.usersservice.persistence;

import com.marco.usersservice.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "users")
public interface UsersDAO extends PagingAndSortingRepository<User, Long> {

    User findByUserName(String userName);

}
