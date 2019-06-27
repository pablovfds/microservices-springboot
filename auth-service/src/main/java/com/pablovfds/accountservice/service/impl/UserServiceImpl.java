package com.pablovfds.accountservice.service.impl;

import com.pablovfds.accountservice.dto.UserDTO;
import com.pablovfds.accountservice.model.User;
import com.pablovfds.accountservice.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public User create(UserDTO userDTO) {
        return null;
    }

    @Override
    public User update(UserDTO userDTO) {
        return null;
    }

    @Override
    public void remove(String id) {

    }

    @Override
    public User findById(String id) {
        return new User("Test", "teste@localhost", "123");
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return null;
    }
}
