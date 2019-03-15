package com.github.user;

import java.util.List;

public interface UserService {
    void save(User user);

    void update(User user);

    User find(Long id);

    void delete(Long id);

    List<User> findAll();

    boolean existUserByEmail(String email);

    User findUserByEmail(String email);

    User findByRegisterToken(String token);
}
