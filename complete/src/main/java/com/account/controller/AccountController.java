package com.account.controller;

import com.account.domain.exception.ErrorCodeException;
import com.account.domain.entity.User;
import com.account.domain.request.SigninRequest;
import com.account.domain.request.SignupRequest;
import com.account.domain.response.SigninResponse;
import com.account.domain.response.SignupResponse;
import com.account.mapper.RequestEntityMapper;
import com.account.service.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/account")
public class AccountController {

    @Autowired
    private RequestEntityMapper requestEntityMapper;
    @Autowired
    private AccountServiceImpl accountServiceImpl;

    @RequestMapping(value = "/sign-up", method = RequestMethod.POST)
    public SignupResponse index(@RequestBody SignupRequest signupRequest) throws ErrorCodeException {
        User user = requestEntityMapper.mapSignUpRequestToUser(signupRequest);
        accountServiceImpl.signup(user);
        SignupResponse signupResponse = new SignupResponse();
        signupResponse.setStatus(HttpStatus.OK.value());
        signupResponse.setMessage("Account Created!");
        return signupResponse;
    }

    @RequestMapping(value = "/sign-in", method = RequestMethod.POST)
    public SigninResponse index(@RequestBody SigninRequest signinRequest) throws ErrorCodeException {
        User user = requestEntityMapper.mapSignInRequestToUser(signinRequest);
        User userResponse = accountServiceImpl.signIn(user);
        SigninResponse signinResponse = SigninResponse.builder().token(userResponse.getToken()).build();
        signinResponse.setStatus(HttpStatus.OK.value());
        signinResponse.setMessage("Sign in successful!");
        return signinResponse;
    }

}
