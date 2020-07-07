package com.priv;

import com.priv.entity.User;
import com.priv.mapper.UserMapper;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
class MybatisPlusDemoApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        //条件封装器queryWrapper,没有的话就是没有条件
        List<User> userList = userMapper.selectList(null);
        //断言，常用于测试,如果相同则继续运行，否则抛出异常
        Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }
}
