package com.smtest.view;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 定义Excel视图
 *
 * @author crabman
 * @Date 2018-05-25 19:54
 */
public class Excelview  extends AbstractXlsView {
    //定义文件的名字
    private String fileName;

    //导出视图自定义借口
    private ExcelExportService excelExportService;

    public Excelview(ExcelExportService excelExportService){
        this.excelExportService=excelExportService;
    }
    public Excelview(String viewName,ExcelExportService excelExportService){
        this.setBeanName(viewName);

    }


    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public ExcelExportService getExcelExportService() {
        return excelExportService;
    }

    public void setExcelExportService(ExcelExportService excelExportService) {
        this.excelExportService = excelExportService;
    }

    @Override
    protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        if(excelExportService==null){
            throw new RuntimeException("导出服务接口不能为null");
        }
        //文件名不能为空
        if(!StringUtils.isEmpty(fileName)){
            //进行字符转换
            String reqCharset=httpServletRequest.getCharacterEncoding();
            reqCharset=reqCharset==null?"UTF-8":reqCharset;
            fileName=new String(fileName.getBytes(reqCharset),"ISO8859-1");
            //设置下面文件名
            httpServletResponse.setHeader("Content-disposition","attachment;filename="+fileName);
        }
        //回调接口方法，使用自定义生成excel文件
        excelExportService.makeWorkBook(model,workbook);
    }
}
