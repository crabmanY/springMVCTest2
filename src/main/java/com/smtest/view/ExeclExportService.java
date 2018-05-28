package com.smtest.view;

import org.apache.poi.ss.usermodel.Workbook;

import java.util.Map;

/**
 * @description：自定义接口导出
 * @author:crabman
 * @Date:2018-05-26-10:10
 */
public interface ExeclExportService {
    /**
     * 生成exel文件的规则
     * @param model 数据模型
     * @param workbook 生成excel表的方法
     * */
    public void makeWorkBook(Map<String,Object> model, Workbook workbook);



}
