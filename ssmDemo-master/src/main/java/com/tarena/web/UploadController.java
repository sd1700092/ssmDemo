package com.tarena.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.UUID;

/**
 * Created by SkyOne on 2016/10/8.
 */
@Controller
@RequestMapping("/upload")
public class UploadController {
    @RequestMapping("/upload.form")
    public String uploadForm(){
        return "upload";
    }

    //处理上载请求的
    @RequestMapping("file-upload.form")
    public String fileUpload(MultipartFile image, String author
    , ModelMap map, HttpServletRequest request) throws Exception{
        //获取原始上载的文件名
        //image.getOriginalFilename();
        //image.getName(); 是上载的属性名称 即image
        //image.getBytes(); 上载的全部byte数据
        //image.getInputStream(); 获取数据流
        //image.getContentType(); //获取文件的类型
        //1 创建目标文件夹 /WEB-INF/images
        // 转化为实际磁盘的路径
        String path = "/WEB-INF/images";
        path = request.getSession().getServletContext().getRealPath(path);
        System.out.println("实际路径：" + path);
        File dir = new File(path);
        if(! dir.exists()){
            dir.mkdir();
        }
        String uuid = UUID.randomUUID().toString();
        String fileName = image.getOriginalFilename();
        String img = uuid + fileName.substring(fileName.lastIndexOf("."));
        String txt = uuid + ".txt";
        //写出图片文件
        FileOutputStream imgOut = new FileOutputStream(new File(dir, img));
        imgOut.write(image.getBytes());
        imgOut.close();
        //写出元数据文本文件
        PrintWriter out = new PrintWriter(new File(dir, txt));
        out.println("原始文件名：" + fileName);
        out.println("作者：" + author);
        out.println("ContentType：" + image.getContentType());
        out.close();
        //返回到成功页面
        map.put("msg", "成功上载" + fileName);
        return "success";
    }

    @ExceptionHandler
    public String execute(HttpServletRequest request, Exception e) throws Exception{
        if(e instanceof MaxUploadSizeExceededException){
            request.setAttribute("error", "上载文件过大！");
            return "upload";
        }
        throw e;
    }
}
