package com.shaziyou.demo.mapper;

import com.shaziyou.demo.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserMapperTest {

    @Resource
    private UserMapper userMapper;

    @Test
    public void testSelectByUserName() {
        User user = userMapper.selectByUserName("shaziyou");
        String expected = "ADMIN";
        Assert.assertEquals(expected, user.getRoles());
    }

}
