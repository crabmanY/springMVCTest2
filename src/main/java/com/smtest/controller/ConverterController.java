package com.smtest.controller;

import com.smtest.pojo.FormatPojo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

/**
 * @description：日期金额格式转换controller
 * @author:crabman
 * @Date:2018-05-29-14:58
 */

@Controller
@RequestMapping("/converter")
public class ConverterController {
    @RequestMapping("/date")
    public ModelAndView format(FormatPojo pojo){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("pojo",pojo);
        modelAndView.setView(new MappingJackson2JsonView());
        return modelAndView;
    }


}
