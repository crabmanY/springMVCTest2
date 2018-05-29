package com.smtest.controller.advice;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 全局的控制器
 *
 * @author crabman
 * @Date 2018-05-29 18:12
 */
@ControllerAdvice(basePackages = {"com.smtest.controller.advice"})
public class CommonControllerAdvice {
    //定义HTTP对应参数处理规则
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        //针对日期的格式化。其中CustomDateEditor是客户自定义编辑器
        //他的boolean参数表示是否允许为空
        webDataBinder.registerCustomEditor(Date.class,new CustomDateEditor(new SimpleDateFormat("yyyy-MM-hh"),false));
    }
    //处理数据模型，如果返回对象，对象就会保存在数据模型中
    @ModelAttribute
    public void populateModel(Model model){

        model.addAttribute("projectName","chapter16");
    }
    //异常处理，使得拦截的控制器方法发生异常时，都能用相同的视图响应
    @ExceptionHandler(Exception.class)
    public String exception(){
        return "exception";
    }
}
