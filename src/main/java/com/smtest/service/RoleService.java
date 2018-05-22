package com.smtest.service;

import com.smtest.pojo.Role;
import com.smtest.pojo.RoleParams;

import java.util.List;

/**
 * @description：service层
 * @author:crabman
 * @Date:2018-05-21-8:55
 */

public interface RoleService {
    public int insertRole(Role role);
    public Role getRole(int id);
    public List<Role> findRole(RoleParams roleParams);
    public int deleteRole(List<Integer> idList);
    public int insertRoles(List<Role> roleList);
}
