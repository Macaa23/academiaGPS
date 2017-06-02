package com.ubb.gps.account.service;

import com.ubb.gps.account.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}