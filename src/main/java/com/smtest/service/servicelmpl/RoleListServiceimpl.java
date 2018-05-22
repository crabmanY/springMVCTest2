package com.smtest.service.servicelmpl;

import com.smtest.pojo.Role;
import com.smtest.service.RoleListService;
import com.smtest.service.RoleService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @description：service接口实现类
 * @author:crabman
 * @Date:2018-05-21-9:00
 */
@Component
public class RoleListServiceimpl implements RoleListService {

    @Autowired
    private RoleService roleService;
    Logger logger=Logger.getLogger(RoleListServiceimpl.class);
    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED,rollbackFor = Exception.class)
    public int insertRoleList(List<Role> roleList) {
        int count=0;
        for (Role role : roleList) {
            try {
                count += roleService.insertRole(role);
            }catch (Exception e){
                logger.info(e);
            }
        }
        return count;
    }
}
