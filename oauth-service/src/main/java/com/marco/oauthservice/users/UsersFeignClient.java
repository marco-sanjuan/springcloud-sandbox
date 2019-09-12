package com.marco.oauthservice.users;

import com.marco.oauthservice.users.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("users-service")
public interface UsersFeignClient {

    @GetMapping("/users/search/findByUserName")
    User findByUserName(@RequestParam String userName);
}
