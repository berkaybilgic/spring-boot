package com.activityistanbul.gezidb.service.Concretes;


import com.activityistanbul.gezidb.dataAcces.UsersDao;
import com.activityistanbul.gezidb.entites.CustomUserDetails;
import com.activityistanbul.gezidb.entites.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsersDao usersDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = usersDao.findByEmail(username);
        if (users == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomUserDetails(users);
    }

}