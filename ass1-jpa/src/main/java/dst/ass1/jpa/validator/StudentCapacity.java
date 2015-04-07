package dst.ass1.jpa.validator;

import javax.validation.Constraint;
import javax.validation.OverridesAttribute;
import javax.validation.Payload;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = {StudentCapacityValidator.class})
@Target({FIELD })
@Retention(RUNTIME)
public @interface StudentCapacity {

    int min();

    int max();

    String message() default "The value has to be between {min} and {max} ";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };


}
