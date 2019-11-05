package com.jiefeng.imagesbed.dao;

import com.definesys.mpaas.query.MpaasQueryFactory;
import com.jiefeng.imagesbed.pojo.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * UserDao
 */
@Component
public class UserDao {

    @Autowired
    private MpaasQueryFactory sw;

	public void registered(User user) {
        sw.buildQuery()
            .doInsert(user);
	}

    
}