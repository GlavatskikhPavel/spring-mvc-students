package ru.glavatskikh.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.glavatskikh.model.Student;

@Component
public class StudentValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Student.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Student student = (Student) o;
        if (student.getGroup().getName().equals("")) {
            errors.rejectValue("group.name", "", "Группа не должна быть пустой");
        }
    }
}
