package com.simpriv.api.application.snippet.facade;

import com.simpriv.api.application.snippet.AuthenticationFacade;
import com.simpriv.api.application.user.custom.CustomUserPrincipal;
import com.simpriv.api.domain.user.User;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.inject.Named;

//TODO: Facade or Adapter
@Named
public class AuthenticationFacadeImpl implements AuthenticationFacade {

    @Override
    public User getUserFromContext() {
         CustomUserPrincipal customUserPrincipal = (CustomUserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return customUserPrincipal.getUser();
    }
}
