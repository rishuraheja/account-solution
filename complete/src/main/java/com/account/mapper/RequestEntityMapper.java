package com.account.mapper;

import com.account.domain.entity.User;
import com.account.domain.request.SigninRequest;
import org.springframework.stereotype.Component;
import com.account.domain.request.SignupRequest;

@Component
public class RequestEntityMapper {

    public User mapSignUpRequestToUser(SignupRequest signupRequest) {
        return User.builder().userName(signupRequest.getUserName())
                .password(signupRequest.getPassword()).build();
    }

    public User mapSignInRequestToUser(SigninRequest signinRequest) {
        return User.builder().userName(signinRequest.getUserName())
                .password(signinRequest.getPassword()).build();
    }

}
