package com.smtest.validator;

import com.smtest.pojo.Transaction;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * @description：使用验证器
 * @author:crabman
 * @Date:2018-05-25-15:17
 */
public class TransacitonValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Transaction.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Transaction transaction = (Transaction) o;
        double dis=transaction.getAmount()-(transaction.getQuantity()*transaction.getPrice());
        //如果差额大于0.01，则认为业务错误
        if(Math.abs(dis)>0.01){
            errors.rejectValue("amount",null,"交易金额与购买数量和价格不匹配");
        }

    }
}
