package com.smtest.controller;

import com.smtest.pojo.*;
import com.smtest.service.RoleService;
import com.smtest.validator.TransacitonValidator;
import com.smtest.view.ExcelExportService;
import com.smtest.view.Excelview;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.DataBinder;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * @description：验证表单的Controller
 * @author:crabman
 * @Date:2018-05-25-14:58
 */
@Controller
@RequestMapping("/validate")
public class ValidateController {
    @Autowired
    private RoleService roleService;
    @InitBinder
    public void initBinder(DataBinder binder){
        //数据绑定器加入验证器
        binder.setValidator(new TransacitonValidator());
    }
    @RequestMapping("/annotation")
        public ModelAndView validate(@Valid Transaction transaction, Errors errors){
            //是否存在错误
        if(errors.hasErrors()){

            //获取错误的信息
            List<FieldError> errorList = errors.getFieldErrors();
            for (FieldError error : errorList) {
                //打印字段错误的信息
                System.err.println("field:"+error.getField()+" "+"msg:"+error.getDefaultMessage());
            }
        }
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }


    @RequestMapping(value = "/export",method = RequestMethod.GET)
    public ModelAndView export(){
        ModelAndView modelAndView=new ModelAndView();
        Excelview excelview=new Excelview(excelExportService());
        excelview.setFileName("所有角色.xmls");
        //设置sql后台参数
        RoleParams roleParams=new RoleParams();
        roleParams.setRoleName("crab");
        roleParams.setNote("你");
        //限制一万条
        pageParams pageParams=new pageParams();
        pageParams.setStart(0);
        pageParams.setLimit(10000);
        roleParams.setPageParams(pageParams);
        List<Role> roleList = roleService.findRole(roleParams);
        modelAndView.addObject("rolelist",roleList);
        modelAndView.setView(excelview);
        return modelAndView;
    }
    @SuppressWarnings({"unchecked"})
    private ExcelExportService excelExportService(){
        //使用lambda表达式自定义带出excel规则
        return (Map<String,Object> model,Workbook workbook) ->{
            List<Role> rolelist = (List<Role>) model.get("rolelist");
            //生成sheet
            Sheet sheet=workbook.createSheet("所有角色");
            //加载标题
            Row title=sheet.createRow(0);
            title.createCell(0).setCellValue("编号");
            title.createCell(1).setCellValue("名称");
            title.createCell(2).setCellValue("备注");
            //遍历角色列表，生成数据
            for(int i=0;i<rolelist.size();i++){
                Role role=rolelist.get(i);
                int roleIdx=i+1;
                Row row=sheet.createRow(roleIdx);
                row.createCell(0).setCellValue(role.getId());
                row.createCell(1).setCellValue(role.getRolename());
                row.createCell(2).setCellValue(role.getNote());
            }
        } ;


    }

}
