package com.account.service;

import com.account.domain.entity.User;
import com.account.domain.exception.ErrorCodeException;
import com.account.repository.UserRepository;
import com.account.service.iface.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void signup(User user) throws ErrorCodeException {
        user.setId(UUID.randomUUID());
        user.setToken(UUID.randomUUID().toString());
        User existingUser = userRepository.findByUserName(user.getUserName());
        if (existingUser != null) {
            throw new ErrorCodeException(HttpStatus.UNPROCESSABLE_ENTITY.value(), "Account already exists!");
        }
        userRepository.save(user);
    }

    @Override
    public User signIn(User user) throws ErrorCodeException {
        User existingUser = userRepository.findByUserName(user.getUserName());
        if (existingUser == null) {
            throw new ErrorCodeException(HttpStatus.UNPROCESSABLE_ENTITY.value(), "Account Doesn't exist");
        } else if (!existingUser.getPassword().equals(user.getPassword())) {
            throw new ErrorCodeException(HttpStatus.UNPROCESSABLE_ENTITY.value(), "Username Password Mismatch");
        }
        return existingUser;
    }

}
