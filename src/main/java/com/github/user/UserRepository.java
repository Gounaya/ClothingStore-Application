package com.github.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsUserByEmail(String email);
    long countUserByEmail(String email);
    User findUserByEmail(String email);
    User findByRegisterToken(String token);
}
