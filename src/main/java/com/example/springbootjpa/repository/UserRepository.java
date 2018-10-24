package com.example.springbootjpa.repository;

import com.example.springbootjpa.domin.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 作者: lin
 * 描述:
 * 日期: 2018/10/24 14:14
 */
public interface UserRepository extends JpaRepository<User,Long> {

    public List<User> findAll();
}
