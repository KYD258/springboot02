package com.qf.test;

import com.MySpringBootApplication;
import com.qf.domain.User;
import com.qf.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MySpringBootApplication.class)
public class UserTest {
    @Resource
    private UserService userService;

    @Test
    public void test(){
        User u = new User();
        u.setSex("女");
        System.out.println(userService.update(null,u));
        System.out.println(123456);
    }
}
