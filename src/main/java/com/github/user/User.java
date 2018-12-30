package com.github.user;

import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 3, max = 32)
    private String firstName;

    @Size(min = 3, max = 32)
    private String lastName;

    @Email
    private String email;

    @Size(min = 6, max = 32)
    private String password;

    @NotNull
    private char gender;

    @NotNull
    private boolean newsletter;

}
