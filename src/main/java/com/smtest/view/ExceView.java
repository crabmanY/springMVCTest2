package com.smtest.view;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @description：可实例化的Excel视图类
 * @author:crabman
 * @Date:2018-05-26-10:20
 */
public class ExceView extends AbstractXlsView {
    private String fileName;

    private  ExeclExportService execlExportService;

    public ExceView(ExeclExportService execlExportService){
        this.execlExportService=execlExportService;
    }
    public ExceView(String viewName,ExeclExportService execlExportService){
        this.setBeanName(viewName);
    }

    @Override
    protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
    if(execlExportService==null){
        throw new RuntimeException("导出服务的接口不能为null");
    }
    //文件名不能为空，如果为空则使用请求路径中的字符串当作文件名
        if(!StringUtils.isEmpty(fileName)){
        String reqCharset=httpServletRequest.getCharacterEncoding();
        reqCharset=reqCharset==null?"UTF-8":reqCharset;
        fileName=new String(fileName.getBytes(reqCharset),"ISO8859-1");
        httpServletResponse.setHeader("Content-disposition","attachment;filename="+fileName);
        //回调接口方法自定义生成Excel文档
        execlExportService.makeWorkBook(model,workbook);
        }
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public ExeclExportService getExeclExportService() {
        return execlExportService;
    }

    public void setExeclExportService(ExeclExportService execlExportService) {
        this.execlExportService = execlExportService;
    }
}
