package com.smtest.controller.advice;

import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * 测试通知的advice
 *
 * @author crabman
 * @Date 2018-05-29 18:30
 */
@Controller
@RequestMapping("advice")
public class MyadviceController {
    @RequestMapping("/test")
    @ResponseBody
    public Map<String,Object> testAdvice(Date date, @NumberFormat(pattern = "##,###.00")BigDecimal amount, Model model){
        Map<String,Object> map=new HashMap<>();
        map.put("project_name",model.asMap().get("projectName"));
        map.put("date",DateUtils.format(date,"yyyy-MM-dd"));
        map.put("amount",amount);
        return map;
    }
    /**
     * 测试异常
     * */
    @RequestMapping("/exception")
    public void exception(){
        throw new RuntimeException("测试异常跳转");

    }

}
