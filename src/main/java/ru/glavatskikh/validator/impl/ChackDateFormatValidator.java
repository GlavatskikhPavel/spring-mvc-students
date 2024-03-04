package ru.glavatskikh.validator.impl;

import ru.glavatskikh.validator.ChackDateFormat;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Date;

public class ChackDateFormatValidator implements ConstraintValidator<ChackDateFormat, Date> {

    @Override
    public boolean isValid(Date date, ConstraintValidatorContext constraintValidatorContext) {
        return date != null;
    }
}
