package com.smtest.pojo;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @description：传递转换参数的pojo
 * @author:crabman
 * @Date:2018-05-29-15:23
 */
public class FormatPojo {
    public Date getDate1() {
        return date1;
    }

    public void setDate1(Date date1) {
        this.date1 = date1;
    }

    public BigDecimal getAmount1() {
        return amount1;
    }

    public void setAmount1(BigDecimal amount1) {
        this.amount1 = amount1;
    }

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date date1;
    @NumberFormat(pattern = "##,###.00")
    private BigDecimal amount1;

}
