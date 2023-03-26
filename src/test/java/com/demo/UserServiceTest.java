package com.demo;

import com.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void getById() {
        System.out.println(userService.getById(1));
    }

    @Test
    public void getAll() {
        System.out.println(userService.getAll());
    }

    // 测试事务
    @Test
    public void transferMoney() {
        System.out.println(userService.getClass());
        userService.transferMoney("jack", "rose", 10.0);
    }
}
