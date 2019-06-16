package com.mitrais.registerformdemo.service;

import com.mitrais.registerformdemo.model.User;

public interface UserService {
    void save(User user);

    User findByEmail(String email);
    User findByMobileNumber(String mobileNumber);
}
