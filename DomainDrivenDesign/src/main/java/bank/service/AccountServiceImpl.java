package com.example.bank.service.impl;

import com.example.bank.model.User;
import com.example.bank.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public List<User> getAllUsers() {
        return Arrays.asList(
                new User(1L, "Alice"),
                new User(2L, "Bob"));
    }
}
