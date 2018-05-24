package com.smtest.controller;

import com.smtest.pojo.Role;
import com.smtest.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

/**
 * @description：对session和requset中获取和保存的控制器
 * @author:crabman
 * @Date:2018-05-24-14:10
 */
@Controller
@RequestMapping("/attribute")
@SessionAttributes(names = {"id"},types = {Role.class})
public class AttributeController {
    @Autowired
    RoleService roleService;
    @RequestMapping("/requestAttribute")
    public ModelAndView reqAddr(@RequestAttribute("id") int id){
        ModelAndView modelAndView=new ModelAndView();
        Role role=roleService.getRole(id);
        modelAndView.addObject("role",role);
        modelAndView.setView(new MappingJackson2JsonView());
        return modelAndView;
    }
    @RequestMapping("/sessionAttrs")
    public ModelAndView sessionAttr(int id){
    ModelAndView modelAndView=new ModelAndView();
    Role role=roleService.getRole(id);
    modelAndView.addObject("role",role);
    modelAndView.addObject("id",id);
    modelAndView.setViewName("sessionAttribute");
    return modelAndView;
    }
    @RequestMapping("sessionAttribute")
    public ModelAndView sessionattr(@SessionAttribute("id") int id){
    ModelAndView modelAndView=new ModelAndView();
    Role role=roleService.getRole(id);
    modelAndView.addObject("role",role);
    modelAndView.setView(new MappingJackson2JsonView());
    return modelAndView;
    }
    /**
     *
     * 请求头和cookieValue
     * */
    @RequestMapping("/getHeaderAndCookie")
    public String testHeaderAndCookie(@RequestHeader(value ="User-Agent",required = false,defaultValue = "attribute")String userAgent,
        @CookieValue(value="JSESSIONID",required = true,defaultValue = "Myjseesonid" ) String jsessionid
    ){
        System.out.println(userAgent);
        System.out.println(jsessionid);
        return "index";
    }
}
