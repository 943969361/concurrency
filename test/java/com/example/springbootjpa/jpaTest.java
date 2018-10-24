package com.example.springbootjpa;

import com.example.springbootjpa.domin.User;
import com.example.springbootjpa.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * 作者: lin
 * 描述:
 * 日期: 2018/10/24 14:21
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes =SpringbootjpaApplication.class )
public class jpaTest {

    @Autowired
    private UserRepository userRepository;
    @Test
    public  void test(){
        List<User> all = userRepository.findAll();
        System.out.println(all);

    }
}
