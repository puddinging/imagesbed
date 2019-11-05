package com.jiefeng.imagesbed.service;

import java.util.Map;

import com.jiefeng.imagesbed.dao.UserDao;
import com.jiefeng.imagesbed.pojo.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * UserService
 */
@Service
public class UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserDao dao;

	public void registered(Map<String, String> map) {
        // 实现密码加密存储
        String name = map.get("name");
        String password = map.get("password");
        User user = new User();
        user.setName(name);
        user.setPassword(passwordEncoder.encode(password));
        dao.registered(user);
	}
}