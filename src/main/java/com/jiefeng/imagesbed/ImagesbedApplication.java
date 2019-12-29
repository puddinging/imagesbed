/*
 * @Copyright: Shanghai Definesys Company.All rights reserved.
 * @Descripttion: 
 * @Author: jiefeng
 * @Date: 2019-10-28 16:30:12
 * @LastEditors: jiefeng
 * @LastEditTime: 2019-11-05 16:33:42
 */
package com.jiefeng.imagesbed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.definesys.mpaas","com.jiefeng.imagesbed"})
public class ImagesbedApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImagesbedApplication.class, args);
    }
}
