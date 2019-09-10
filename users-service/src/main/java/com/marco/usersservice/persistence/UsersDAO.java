package com.marco.usersservice.persistence;

import com.marco.usersservice.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UsersDAO extends PagingAndSortingRepository<User, Long> {

    User findByUserName(String userName);

}
