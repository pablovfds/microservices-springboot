package com.pablovfds.accountservice.controller;

import com.pablovfds.accountservice.dto.UserDTO;
import com.pablovfds.accountservice.model.User;
import com.pablovfds.accountservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/users")
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
