package com.pablovfds.accountservice.service;

import com.pablovfds.accountservice.dto.UserDTO;
import com.pablovfds.accountservice.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    User create(UserDTO userDTO);
    User update(UserDTO userDTO);
    void remove(String id);
    User findById(String id);
    Page<User> findAll(Pageable pageable);
}
