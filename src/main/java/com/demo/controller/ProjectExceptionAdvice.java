package com.demo.controller;

import com.demo.exception.BusinessException;
import com.demo.exception.SystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// AOP 自动织入所有的 RestController
@RestControllerAdvice
public class ProjectExceptionAdvice {
    /**
     * 业务异常处理器
     * @param e
     * @return
     */
    @ExceptionHandler(BusinessException.class)
    public Result doBusinessException(BusinessException e) {
        // 返回数据
        return new Result(e.getCode(), null, e.getMessage());
    }

    /**
     * 系统异常处理器
     * @param e
     * @return
     */
    @ExceptionHandler(SystemException.class)
    public Result doSystemException(SystemException e) {
        // TODO 记录日志（错误堆栈）

        // TODO 发送消息给运维、开发

        // 返回数据
        return new Result(e.getCode(), null, e.getMessage());
    }

    /**
     * 其他异常处理器
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public Result doException(Exception e) {
        // TODO 记录日志（错误堆栈）

        // TODO 发送消息给开发

        // 返回数据
        return new Result(Code.SYSTEM_UNKNOWN_ERROR, null, "系统繁忙，请稍候再试！");
    }
}
