package com.ljl.gulimall.product.exception;

import com.ljl.common.exception.CodeEnums;
import com.ljl.common.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestControllerAdvice(basePackages = "com.ljl.gulimall.product.controller")
public class ControllerAdviceException {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public R handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error("发生异常信息: {}, 异常类型: {}", e.getMessage(), e.getClass());
        Map<String, String> m = new HashMap<>();
        BindingResult bindingResult = e.getBindingResult();
        bindingResult.getFieldErrors().forEach( (item) -> {
            String msg = item.getDefaultMessage();
            String field = item.getField();
            m.put(field, msg);
        });
        return R.error(CodeEnums.VALID_EXCEPTION.getCode(), CodeEnums.VALID_EXCEPTION.getMsg()).put("data", m);
    }

    @ExceptionHandler(value = Throwable.class)
    public R handleThrowable(Throwable throwable) {
        return R.error(CodeEnums.UNKNOWN_EXCEPTION.getCode(), CodeEnums.UNKNOWN_EXCEPTION.getMsg());
    }
}
