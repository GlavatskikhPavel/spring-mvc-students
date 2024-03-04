package ru.glavatskikh.validator;

import ru.glavatskikh.validator.impl.ChackDateFormatValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ChackDateFormatValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ChackDateFormat {
    String message() default "дд/мм/гггг";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
