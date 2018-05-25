package com.smtest.controller;

import com.smtest.pojo.Transaction;
import com.smtest.validator.TransacitonValidator;
import org.springframework.stereotype.Controller;
import org.springframework.validation.DataBinder;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

/**
 * @description：验证表单的Controller
 * @author:crabman
 * @Date:2018-05-25-14:58
 */
@Controller
@RequestMapping("/validate")
public class ValidateController {
    @InitBinder
    public void initBinder(DataBinder binder){
        //数据绑定器加入验证器
        binder.setValidator(new TransacitonValidator());
    }
    @RequestMapping("/annotation")
        public ModelAndView validate(@Valid Transaction transaction, Errors errors){
            //是否存在错误
        if(errors.hasErrors()){

            //获取错误的信息
            List<FieldError> errorList = errors.getFieldErrors();
            for (FieldError error : errorList) {
                //打印字段错误的信息
                System.err.println("field:"+error.getField()+" "+"msg:"+error.getDefaultMessage());
            }
        }
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }



}
