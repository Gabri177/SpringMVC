package com.yugao.controller;

import com.yugao.exception.BusinissException;
import com.yugao.exception.SystemException;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;

//@RestControllerAdvice用于标识当前类为REST风格对应的异常处理器
@RestControllerAdvice
public class ProjectExceptionAdvice {
    //@ExceptionHandler用于设置当前处理器类对应的异常类型
    @ExceptionHandler(SystemException.class)
    public Result doSystemException(SystemException ex){
        //记录日志
        //发送消息给运维
        //发送邮件给开发人员,ex对象发送给开发人员
        return new Result(ex.getCode(),ex.getMessage());
    }

    @ExceptionHandler(BusinissException.class)
    public Result doBusinessException(BusinissException ex){
        return new Result(ex.getCode(),ex.getMessage());
    }

    @ExceptionHandler(DataAccessException.class)
    public Result doSQLException(SQLException ex){
        return new Result(666,"数据库异常，请稍后再试！");
    }

    //除了自定义的异常处理器，保留对Exception类型的异常处理，用于处理非预期的异常
    @ExceptionHandler(Exception.class)
    public Result doOtherException(Exception ex){
        //记录日志
        //发送消息给运维
        //发送邮件给开发人员,ex对象发送给开发人员
        System.out.println("doOtherException ==> " + ex);
        return new Result(Code.SYSTEM_UNKNOW_ERR,"系统繁忙，请稍后再试！");
    }
}
