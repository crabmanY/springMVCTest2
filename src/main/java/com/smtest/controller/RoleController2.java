package com.smtest.controller;

import com.smtest.pojo.Role;
import com.smtest.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description：json消息转换器的controller
 * @author:crabman
 * @Date:2018-05-28-15:13
 */
@RequestMapping("/role2")
@Controller
public class RoleController2 {
    //注册角色服务类
    @Autowired
    private RoleService roleService;
    @RequestMapping("/getRole")
    @ResponseBody
//注解使得SpringMvc将结果转换为JSon类型响应
    public Role getRole(int id){
        Role role=roleService.getRole(id);
        return role;
    }
    @RequestMapping("/insertRole")
    @ResponseBody
    public Map<String,Object> updateRole(@RequestParam("role") Role role){
        Map<String,Object> result=new HashMap<String, Object>();
        //更新角色
        boolean updateFlag=(roleService.insertRole(role)==1);
        result.put("success",updateFlag);
        if(updateFlag){
            result.put("msg","更新成功");
        }else{

            result.put("msg","更新失败");
        }
        return  result;
    }
    @RequestMapping("/uodateRoleList")
    @ResponseBody
    public Map<String,Object> updateRoleList(List<Role> roleList){
    Map<String,Object> result=new HashMap<>();
    //更新角色列表
        boolean uodateFlag=

                roleService.insertRoles(roleList)>1;
        result.put("success",uodateFlag);
        if(uodateFlag){
            result.put("msg","更新成功");
        }else{
            result.put("msg","更新失败");
        }

            return result;

    }
}
