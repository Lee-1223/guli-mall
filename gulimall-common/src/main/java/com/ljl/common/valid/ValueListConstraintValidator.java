package com.ljl.common.valid;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.HashSet;

public class ValueListConstraintValidator implements ConstraintValidator<ValueList, Integer> {

    private HashSet<Integer> s = new HashSet<Integer>();

    // 初始化，获取一些注解的属性等详细信息
    @Override
    public void initialize(ValueList constraintAnnotation) {
        int[] values = constraintAnnotation.values();
        System.out.println(values.length);
        for (int value : values) {
            s.add(value);
        }
    }

    // 第一个参数就是要校验的值
    @Override
    public boolean isValid(Integer integer, ConstraintValidatorContext constraintValidatorContext) {
        return s.contains(integer);
    }

}
