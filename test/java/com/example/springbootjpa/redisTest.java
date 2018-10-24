package com.example.springbootjpa;

import com.example.springbootjpa.domin.User;
import com.example.springbootjpa.repository.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * 作者: lin
 * 描述:
 * 日期: 2018/10/24 14:48
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootjpaApplication.class)
public class redisTest {

    @Autowired
    private RedisTemplate<String,String> redisTemplte;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void test() throws JsonProcessingException {

        // 1.从redis中获取
        String userfindall = redisTemplte.boundValueOps("userfindall").get();
        if(null == userfindall){
            // 2.redis中没有从数据库查询
            List<User> all = userRepository.findAll();
            // 2.1将数组转换为string
            ObjectMapper objectMapper = new ObjectMapper();
            userfindall = objectMapper.writeValueAsString(all);
            // 3.查询过后存入redis
            redisTemplte.boundValueOps("userfindall").set(userfindall);
            System.out.println("=======数据库查询=========");
        }else {
            System.out.println("=======redis缓存=========");
            // 4.控制台打印

        }

    }
}
