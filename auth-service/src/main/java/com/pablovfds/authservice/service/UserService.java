package com.pablovfds.authservice.service;

import com.pablovfds.authservice.dto.UserDTO;
import com.pablovfds.authservice.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    User create(UserDTO userDTO);
    User update(UserDTO userDTO);
    void remove(String id);
    User findById(String id);
    Page<User> findAll(Pageable pageable);
    User findByEmail(String email);
}
