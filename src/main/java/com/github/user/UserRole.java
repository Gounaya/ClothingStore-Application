package com.github.user;

import javax.persistence.*;

@Entity
@Table(name="user_roles")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   // @Column()
    private boolean user;
    private boolean admin;
    private boolean moderator;
}
