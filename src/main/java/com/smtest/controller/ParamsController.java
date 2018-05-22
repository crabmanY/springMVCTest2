package com.smtest.controller;

import com.smtest.pojo.Role;
import com.smtest.pojo.RoleParams;
import com.smtest.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.List;

/**
 * @description：接受参数的控制器
 * @author:crabman
 * @Date:2018-05-22-10:28
 */
@Controller
@RequestMapping("/param")
public class ParamsController {
    /**
     * 接受普通的参数请求
     */
    @RequestMapping("/commonParams")
    public ModelAndView commonParams(String roleName, String note) {
        System.out.println("roleName=>" + roleName);
        System.out.println("note=>" + note);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    /**
     * 用pojo封装参数，直接接收pojo对象
     */
    @RequestMapping("/commonParamsPojo")
    public ModelAndView commonParamsPojo(RoleParams roleParams) {
        System.out.println("roleName=>" + roleParams.getRoleName());
        System.out.println("note=>" + roleParams.getNote());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    /**
     * 当定义的参数和前端页面的参数名称不一致的时候，需要用@RequestParam来转换
     */
    @RequestMapping("/requestParam")
    public ModelAndView requestParam(@RequestParam(value = "role_name", required = false) String roleName, String note) {
        System.out.println("rolename=>" + roleName);
        System.out.println("note=>" + note);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @Autowired
    RoleService roleService;
        /**
         * 使用URL传递参数，更符合RESTful风格，需要使用连个注解配合使用
         *@param @RequestMapping
         *@param @PathVariable
         * */
        @RequestMapping("/getRole/{id}")
        public ModelAndView pathVariable(@PathVariable("id") int id){
            Role role=roleService.getRole(id);
            ModelAndView modelAndView=new ModelAndView();
            modelAndView.addObject(role);
            //在设置json视图的时候要注意是setview不是setviewname
            modelAndView.setView(new MappingJackson2JsonView());
            return modelAndView;
        }
        /**
         *传递json参数
         * */
        @RequestMapping("/findRole")
        public ModelAndView findRole(@RequestBody RoleParams roleParams){
            List<Role> roleList = roleService.findRole(roleParams);
            ModelAndView modelAndView=new ModelAndView();
            modelAndView.addObject(roleList);
            modelAndView.setView(new MappingJackson2JsonView());
            return modelAndView;
        }
}