package com.simpriv.api.application.snippet;

import com.simpriv.api.domain.user.User;

public interface AuthenticationFacade {

    User getUserFromContext();
}
