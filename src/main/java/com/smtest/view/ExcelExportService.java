package com.smtest.view;

import org.apache.poi.ss.usermodel.Workbook;

import java.util.Map;

public interface ExcelExportService {

        /**
         * 生成Excel文件规则
         *
         *  @param model 数据模型
         * @param workbook 核心对象
         *
         * */
    public void makeWorkBook(Map<String,Object> model, Workbook workbook);




}
