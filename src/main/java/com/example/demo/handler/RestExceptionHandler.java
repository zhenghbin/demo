package com.example.demo.handler;

import com.example.demo.constant.ApiCode;
import com.example.demo.model.RestResponseVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author zhbin
 * @date 2019-08-19
 */
@RestControllerAdvice
public class RestExceptionHandler {
    private static Logger log = LoggerFactory.getLogger(RestExceptionHandler.class);

    /**
     * 参数绑定异常
     *
     * @param e 异常
     * @return 异常结果
     */
    @ExceptionHandler(value = BindException.class)
    public RestResponseVO handleBindException(BindException e) {
        log.error("参数绑定校验异常:{}", e.getMessage());

        return wrapperBindingResult(e.getBindingResult());
    }

    /**
     * 参数绑定异常
     *
     * @param e 异常
     * @return 异常结果
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public RestResponseVO handleBindException(MethodArgumentNotValidException e) {
        log.error("参数绑定校验异常:{}", e.getMessage());

        return wrapperBindingResult(e.getBindingResult());
    }

    /**
     * 包装绑定异常结果
     *
     * @param bindingResult 绑定结果
     * @return 异常结果
     */
    private RestResponseVO wrapperBindingResult(BindingResult bindingResult) {
        StringBuilder msg = new StringBuilder();

        for (ObjectError error : bindingResult.getAllErrors()) {
            msg.append(", ");
            if (error instanceof FieldError) {
                msg.append(((FieldError) error).getField()).append(": ");
            }
            msg.append(error.getDefaultMessage() == null ? "" : error.getDefaultMessage());

        }

        return RestResponseVO.fail(ApiCode.INTERNAL_SERVER_ERROR, msg.substring(2));
    }
}
