package com.smtest.pojo;

/**
 * @description：参数的pojo类
 * @author:crabman
 * @Date:2018-05-22-10:39
 */
public class RoleParams {
    private String rolename;
    private String note;
    private pageParams pageParams=null;

    public String getRoleName() {
        return rolename;
    }

    public void setRoleName(String rolename) {
        this.rolename = rolename;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setPageParams(com.smtest.pojo.pageParams pageParams) {
        this.pageParams = pageParams;
    }
}
