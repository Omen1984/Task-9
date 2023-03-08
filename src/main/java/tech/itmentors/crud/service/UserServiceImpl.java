package tech.itmentors.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.itmentors.crud.dao.UserDao;
import tech.itmentors.crud.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public List<User> findAll() {
        List<User> users = userDao.findAll();
        return users;
    }

    @Override
    public User findById(long id) {
        return userDao.findById(id);
    }

    @Override
    public void update(User user) {
        userDao.save(user);
    }

    @Override
    public void deleteById(long id) {
        userDao.deleteById(id);
    }
}
