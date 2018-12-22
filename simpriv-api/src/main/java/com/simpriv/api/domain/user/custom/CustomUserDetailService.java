package com.simpriv.api.domain.user.custom;

import com.simpriv.api.domain.user.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class CustomUserDetailService implements UserDetailsService {

    private UserRepository userRepository;

    @Inject
    public CustomUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new CustomUserPrincipal(userRepository.getByUsername(username));
    }
}
