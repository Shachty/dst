package dst.ass1.jpa.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;

public class StudentCapacityValidator implements ConstraintValidator<StudentCapacity, Integer> {

    private int min;
    private int max;

    @Override
    public void initialize(StudentCapacity studentCapacity) {
            this.min = studentCapacity.min();
        this.max = studentCapacity.max();
    }

    @Override
    public boolean isValid(Integer integer, ConstraintValidatorContext constraintValidatorContext) {


        if( integer < min) return false;
        if(integer > max) return false;

        return true;

    }


}
