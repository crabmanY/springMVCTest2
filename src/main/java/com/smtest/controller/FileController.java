package com.smtest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;

/**
 * 第一种容易造成API侵入的文件上传方法
 *
 * @author crabman
 * @Date 2018-05-27 18:40
 */
@Controller
@RequestMapping("/file")
public class FileController {
    @RequestMapping("/upload")
    public ModelAndView modelAndView(HttpServletRequest request){
    //进行转换
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile multipartRequestFile = multipartRequest.getFile("file");
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setView(new MappingJackson2JsonView());
        //获取原始的文件名
        String originalFilename = multipartRequestFile.getOriginalFilename();
        //目标文件
        File dest=new File(originalFilename);
        //保存文件
        try {
            multipartRequestFile.transferTo(dest);
            //保存成功
            modelAndView.addObject("success",true);
            modelAndView.addObject("msg","上传文件成功");
        } catch (IOException e) {
            //保存失败
            modelAndView.addObject("success",false);
            modelAndView.addObject("msg","上传文件失败");
            e.printStackTrace();
        }
        return modelAndView;
    }

    /**
     *
     * 使用springMVC提供的类还有servletAPI提供的类会更加安全，并且更加便利简单，高度解耦，体现了spring的思维
     * */
    @RequestMapping("/multipartFile")
    public ModelAndView multipartFile(MultipartFile file){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setView(new MappingJackson2JsonView());
        //获取原始文件名
        String fileName=file.getOriginalFilename();
        file.getContentType();
        //目标文件
        File dest=new File(fileName);
        //保存文件
        try {
            file.transferTo(dest);
            modelAndView.addObject("success",true);
            modelAndView.addObject("msg","上传文件成功");
        } catch (IOException e) {
            e.printStackTrace();
            modelAndView.addObject("success",false);
            modelAndView.addObject("msg","上传文件失败");
        }
            return modelAndView;
    }
            /**
             * 使用servlet提供的part
             * */

            @RequestMapping("/Part")
            public ModelAndView uploadPart(Part file){
                ModelAndView modelAndView=new ModelAndView();
                modelAndView.setView(new MappingJackson2JsonView());
                //获取原始文件名
                String fileName=file.getName();
                File dest=new File(fileName);
                //保存文件
                try {
                    file.write("G:/testupload/"+fileName);
                    modelAndView.addObject("success",true);
                    modelAndView.addObject("msg","上传文件成功");
                } catch (IOException e) {
                    e.printStackTrace();
                    modelAndView.addObject("success",false);
                    modelAndView.addObject("msg","上传文件失败");
                }
                return modelAndView;

            }
}
