package com.simpriv.api.simpriv.service;

import com.simpriv.api.simpriv.exception.SimPrivException;
import com.simpriv.api.simpriv.object.Snippet;

public interface SnippitService {

    Snippet create(String password, String recieversUsername, Snippet message) throws SimPrivException;

    Snippet getById(String id);
}
