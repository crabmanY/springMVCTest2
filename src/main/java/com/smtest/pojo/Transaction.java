package com.smtest.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.Date;

/**
 * @description：注解验证表单的pojo
 * @author:crabman
 * @Date:2018-05-25-14:30
 */
public class Transaction {
    @NotNull//不为空
    private int productId;
    @NotNull
    private int userId;
    @Future//只能是将来的日期
    @DateTimeFormat(pattern = "yyyy-mm-dd")//进行日期转换
    @NotNull
    private Date date;
    @NotNull
    @DecimalMin(value = "0.1")//最小值为0.1元
    private Double price;
    @Min(1)
    @Max(100)
    @NotNull
    private Integer quantity;
    @NotNull
    @DecimalMax("50000.00")//最大交易金额
    @DecimalMin("1.00")
    private Double amount;
    //使用正则表达式检查邮箱格式以及自定义错误消息提示
    @Pattern(regexp = "^([a-zA-Z0-9]*[-_]?[a-zA-Z0-9]+)*@"+ "([a-zA-Z0-9]*[-_]?[a-zA-Z0-9]+)+[\\.][A-Za-z]{2,3}([\\.][A-Za-z]{2})?$",message = "不符合邮件格式")
    private String email;
    @Size(min = 0,max = 256)//0~255个字节
    private String note;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
