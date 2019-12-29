/*
 * @Copyright: Shanghai Definesys Company.All rights reserved.
 * @Descripttion: 
 * @Author: jiefeng
 * @Date: 2019-10-28 16:39:24
 * @LastEditors: jiefeng
 * @LastEditTime: 2019-11-06 12:07:45
 */
package com.jiefeng.imagesbed.service;

import com.definesys.mpaas.common.exception.MpaasBusinessException;
import com.jiefeng.imagesbed.utils.FileUploadAndDownloadUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ImageService {

//    接收文件持久化,返回文件路径名
    public String uploadImage(MultipartFile file) {

        if (!file.isEmpty()) {
            String fileName = file.getOriginalFilename();
            try {
                String fileUrl = FileUploadAndDownloadUtil.uploadPicture(file,fileName);
                return "fileUrl";
            } catch (IOException e) {
                throw new MpaasBusinessException("图片上传失败，请检查"+e.getMessage());
            }
        }else {
            throw new MpaasBusinessException("传入文件为空，请检查");
        }
    }
// 返回md格式的链接
    public String mdmage(MultipartFile file) {
        String fileName = uploadImage(file);
        return "![](http://101.132.149.94:50001/"+fileName+")";
    }
}
