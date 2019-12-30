/*
 * @Copyright: Shanghai Definesys Company.All rights reserved.
 * @Descripttion: 
 * @Author: jiefeng
 * @Date: 2019-10-28 16:44:40
 * @LastEditors: jiefeng
 * @LastEditTime: 2019-11-05 14:38:58
 */
package com.jiefeng.imagesbed.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class FileUploadAndDownloadUtil {

    /**
     * 图片上传
     * @throws IOException
     * 原本想使用values注解从配置文件加载，但是这是一个静态方法所以无法使用
     */
    public static String uploadPicture(MultipartFile file, String fileName)
            throws IOException{
        String filePath = "/usr/local/images/";
        return uploadPicture(file,filePath,fileName);
    }

    /**
     * 上传图片
     * @param file 图片
     * @param filePath 文件路径
     * @param fileName 文件名
     * @return 唯一的文件名
     * @throws IOException
     */
    public static String uploadPicture(MultipartFile file, String filePath, String fileName)
            throws IOException{
        String suffix ="jpg";
        String[] fileNameArray = fileName.split("\\.");
        if (fileNameArray.length>1){
            suffix = fileNameArray[1];
        }
        fileName = UUID.randomUUID()+"."+suffix;
        // 设置文件存储路径

        File dest = new File( filePath+ fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        file.transferTo(dest);
        return fileName;
    }
}
