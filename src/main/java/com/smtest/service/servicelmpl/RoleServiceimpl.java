package com.smtest.service.servicelmpl;

import com.smtest.mapper.Rolemapper;
import com.smtest.pojo.Role;
import com.smtest.pojo.RoleParams;
import com.smtest.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @description：service实现的接口类
 * @author:crabman
 * @Date:2018-05-21-9:13
 */
@Component
public class RoleServiceimpl implements RoleService {
    @Autowired
    private Rolemapper rolemapper=null;
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED,rollbackFor = Exception.class)
    @Override
    public int insertRole(Role role) {
        return rolemapper.insertRole(role);
    }
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED,rollbackFor = Exception.class)
    @Override
    public Role getRole(int id) {
        return rolemapper.getRole(id);
    }
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED,rollbackFor = Exception.class)
    @Override
    public List<Role> findRole(RoleParams roleParams) {
        return rolemapper.findRole(roleParams);
    }
}
