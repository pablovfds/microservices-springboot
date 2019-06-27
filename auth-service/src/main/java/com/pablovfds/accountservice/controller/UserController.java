package com.pablovfds.accountservice.controller;

import com.pablovfds.accountservice.dto.UserDTO;
import com.pablovfds.accountservice.model.User;
import com.pablovfds.accountservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("")
    public ResponseEntity<User> create(@Valid @RequestBody UserDTO userDTO) {
        return new ResponseEntity<>(this.userService.create(userDTO), HttpStatus.CREATED);
    }

    @PutMapping("")
    public ResponseEntity<User> update(@Valid @RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(this.userService.update(userDTO));
    }

    @GetMapping("")
    public ResponseEntity<Page<User>> findAll(Pageable pageable) {
        return ResponseEntity.ok(this.userService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable String id) {
        return ResponseEntity.ok(this.userService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remove(@PathVariable String id) {
        this.userService.remove(id);
        return ResponseEntity.ok().build();
    }
}
