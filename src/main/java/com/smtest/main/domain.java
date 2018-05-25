package com.smtest.main;

import com.smtest.pojo.Role;
import com.smtest.service.RoleListService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * @description：测试集合环境的主方法
 * @author:crabman
 * @Date:2018-05-21-9:16
 */
public class domain {
    public static void main(String []args){
        ApplicationContext context=new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
        RoleListService roleListService= (RoleListService) context.getBean(RoleListService.class);
        List<Role> roleList= new ArrayList<>();
        for(int i=1;i<10;i++){
            Role role=new Role();
            role.setRolename("crab"+i);
            role.setNote("你"+i);
            roleList.add(role);
        }
        int count=roleListService.insertRoleList(roleList);
        System.out.println(count);

    }
}
