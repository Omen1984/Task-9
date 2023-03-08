package tech.itmentors.crud.service;


import tech.itmentors.crud.model.User;

import java.util.List;

public interface UserService {

    void save(User user);

    List<User> findAll();

    User findById(long id);

    void update(User user);

    void deleteById(long id);

}
