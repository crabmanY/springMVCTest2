package com.smtest.controller;

import com.smtest.pojo.Role;
import com.smtest.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

/**
 * @description：controller层
 * @author:crabman
 * @Date:2018-05-21-15:33
 */
@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    RoleService roleService=null;
    @RequestMapping("/getRole")
    public ModelAndView getRole(@RequestParam("id") int id){
    Role role=roleService.getRole(id);
    ModelAndView modelAndView=new ModelAndView();
    modelAndView.addObject("role",role);
    modelAndView.setViewName("view");
    return modelAndView;
    }
    @RequestMapping("/getRole2")
    public ModelAndView getRole2(@RequestParam("id") int id){
     Role role=roleService.getRole(id);
     ModelAndView modelAndView=new ModelAndView();
     modelAndView.addObject("role",role);
     modelAndView.setView(new MappingJackson2JsonView());
     return modelAndView;
    }
}
