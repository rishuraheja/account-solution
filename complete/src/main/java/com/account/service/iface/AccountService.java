package com.account.service.iface;

import com.account.domain.entity.User;
import com.account.domain.exception.ErrorCodeException;

public interface AccountService {

    void signup(User user) throws ErrorCodeException;
    User signIn(User user) throws ErrorCodeException;

}
