package com.pablovfds.authservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    private String id;

    private String name;

    private String email;

    private String password;
}
