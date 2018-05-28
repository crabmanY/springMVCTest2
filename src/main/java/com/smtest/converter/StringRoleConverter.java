package com.smtest.converter;

import com.smtest.pojo.Role;
import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

/**
 * @description：将字符串转换为角色类的转换器
 * @author:crabman
 * @Date:2018-05-28-15:42
 */
public class StringRoleConverter implements Converter<String,Role> {
    @Override
    public Role convert(String s) {
        //如果为空的话就返回null
        if(StringUtils.isEmpty(s)){
            return null;
        }
        //如果不包含指定的字符的话返回null
      /*  if(s.indexOf("-")==-1){
            return null;
        }*/
        String[] arr=s.split(",");
        //如果数组字符串长度不正确的话返回null
       /* if(arr.length!=3){
            return null;
        }*/
        Role role=new Role();
        role.setId(Integer.parseInt(arr[0]));
        role.setRolename(arr[1]);
        role.setNote(arr[2]);
        return role;
    }
}
