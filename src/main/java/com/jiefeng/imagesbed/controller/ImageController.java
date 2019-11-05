/*
 * @Copyright: Shanghai Definesys Company.All rights reserved.
 * @Descripttion: 
 * @Author: jiefeng
 * @Date: 2019-10-28 16:34:12
 * @LastEditors: jiefeng
 * @LastEditTime: 2019-11-05 15:41:22
 */
package com.jiefeng.imagesbed.controller;

import java.util.List;

import com.definesys.mpaas.common.http.Response;
import com.definesys.mpaas.query.MpaasQueryFactory;
import com.jiefeng.imagesbed.pojo.User;
import com.jiefeng.imagesbed.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = "/api/image")
public class ImageController {

    @Autowired
    private MpaasQueryFactory sw;

    @Autowired
    private ImageService imageService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // 返回存储的图片名字
    @RequestMapping(value = "uploadImage")
    public Response uploadImage(@RequestParam("file") MultipartFile file, @RequestParam("name") String name,
            @RequestParam("password") String password) {
        if (!("jiefeng".equals(name) && "159632".equals(password))) {
            return Response.error("验证失败");
        }
        return Response.ok().data(imageService.uploadImage(file));
    }

    // 返回md格式的链接
    @RequestMapping(value = "mdImage")
    public Response mdImage(@RequestParam("file") MultipartFile file, @RequestParam("name") String name,
            @RequestParam("password") String password) {
        if (!("jiefeng".equals(name) && "159632".equals(password))) {
            return Response.error("验证失败");
        }
        return Response.ok().data(imageService.mdmage(file));
    }

    @RequestMapping(value = "test")
    public Response test() {
        List<User> users = sw.buildQuery()
            .eq("id", 1)
            .doQuery(User.class);
        return Response.ok().data(users);
    }
}
