/*
 * @Copyright: Shanghai Definesys Company.All rights reserved.
 * @Descripttion: 
 * @Author: jiefeng
 * @Date: 2019-11-05 15:52:28
 * @LastEditors: jiefeng
 * @LastEditTime: 2019-11-05 16:17:33
 */
package com.jiefeng.imagesbed.controller;

import java.util.Map;


import com.definesys.mpaas.common.http.Response;
import com.jiefeng.imagesbed.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * User
 */
@RestController
@RequestMapping(value = "/api/user")
public class User {


    @Autowired
    private UserService service;
    
    // 注册一个账号
    @RequestMapping(value = "registered", method = RequestMethod.POST)
    public Response registered(@RequestBody Map<String,String> map){
        service.registered(map);
        return Response.ok();
    }
}