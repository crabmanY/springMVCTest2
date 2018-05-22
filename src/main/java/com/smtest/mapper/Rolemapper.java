package com.smtest.mapper;

import com.smtest.pojo.Role;
import com.smtest.pojo.RoleParams;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description：role接口类
 * @author:crabman
 * @Date:2018-05-21-8:40
 */
@Repository
public interface Rolemapper {
    public int insertRole(Role role);
    public Role getRole(int id);
    public List<Role> findRole(RoleParams roleParams);

}
