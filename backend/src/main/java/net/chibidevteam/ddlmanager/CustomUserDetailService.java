package net.chibidevteam.ddlmanager;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import net.chibidevteam.ddlmanager.model.CustomUserDetails;

@Component
public class CustomUserDetailService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) {
        return new CustomUserDetails(username, null, new ArrayList<>());
    }

}
