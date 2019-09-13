package com.marco.oauthservice.users;

import com.marco.oauthservice.users.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@Primary
public class UsersServiceImpl implements UsersService, UserDetailsService {

    private static Logger log = LoggerFactory.getLogger(UsersServiceImpl.class);

    @Autowired
    private UsersFeignClient usersClient;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = usersClient.findByUserName(userName);
        if(user == null){
            log.error("User '{}' not found", userName );
            throw new UsernameNotFoundException("User '" + userName + "' not found.");
        }
        log.info("User '{}' loged in, with roles: ", userName );
        List<GrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .peek(a -> log.info(a.getAuthority()))
                .collect(toList());
        return new org.springframework.security.core.userdetails.User(
                user.getUserName(),
                user.getPassword(),
                user.getEnabled(),
                true,
                true,
                true,
                authorities
        );
    }

    @Override
    public User findByUserName(String userName) {
        return usersClient.findByUserName(userName);
    }
}
