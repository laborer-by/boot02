package com.demo.service.impl;

import com.demo.dao.UserDao;
import com.demo.pojo.User;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public Boolean save(User user) {
        userDao.insert(user);
        return true;
    }

    @Override
    public Boolean update(User user) {
        userDao.update(user);
        return true;
    }

    @Override
    public Boolean delete(Integer id) {
        userDao.delete(id);
        return true;
    }

    @Override
    public User getById(Integer id) {
        return userDao.getById(id);
    }

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public void transferMoney(String out, String in, Double money) {
        userDao.outMoney(out, money);
        // 抛出 ArithmeticException，测试事务自动回滚
        // int a = 1/0;
        userDao.inMoney(in, money);
    }
}
