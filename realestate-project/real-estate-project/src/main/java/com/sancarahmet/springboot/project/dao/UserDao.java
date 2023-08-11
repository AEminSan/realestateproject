package com.sancarahmet.springboot.project.dao;

import com.sancarahmet.springboot.project.entity.User;

public interface UserDao {

    User findByUserName(String userName);

    User findByUserId(int id);

    void save(User theUser);
}
