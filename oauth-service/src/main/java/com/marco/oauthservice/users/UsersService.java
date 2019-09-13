package com.marco.oauthservice.users;

import com.marco.oauthservice.users.model.User;

public interface UsersService {
    User findByUserName(String userName);
}
