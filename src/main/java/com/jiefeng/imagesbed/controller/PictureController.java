package com.jiefeng.imagesbed.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PictureController {
    @Autowired
    private PasswordEncoder passwordEncoder;

}
