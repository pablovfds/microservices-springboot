package com.pablovfds.authservice.service.impl;

import com.pablovfds.authservice.dto.UserDTO;
import com.pablovfds.authservice.exception.EntityNotFoundException;
import com.pablovfds.authservice.model.User;
import com.pablovfds.authservice.repository.UserRepository;
import com.pablovfds.authservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Override
    public User create(UserDTO userDTO) {

        User user = new User();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));

        return this.userRepository.save(user);
    }

    @Override
    public User update(UserDTO userDTO) {

        User user = this.findById(userDTO.getId());
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());

        return this.userRepository.save(user);
    }

    @Override
    public void remove(String id) {
        this.userRepository.delete(this.findById(id));
    }

    @Override
    public User findById(String id) {
        return this.userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found!"));
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return this.userRepository.findAll(pageable);
    }

    @Override
    public User findByEmail(String email) {
        return this.userRepository.findByEmail(email).orElseThrow(() -> new EntityNotFoundException("User not found!"));
    }
}
