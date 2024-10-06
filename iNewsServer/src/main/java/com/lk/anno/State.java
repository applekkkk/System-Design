package com.lk.anno;

import com.lk.validation.StateValidation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(
        validatedBy = {StateValidation.class}//制定提供规则的类
)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface State {
    String message() default "state参数只能是已发布或草稿";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
