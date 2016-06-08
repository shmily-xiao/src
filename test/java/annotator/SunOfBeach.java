package annotator;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;

/**
 * Created by simpletour_Jenkin on 2016/6/7.
 */
@Target({PARAMETER,FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SunOfBeach {

    int value() default 0;

    String msg() default "";

    String error() default "";

    enum Type {notNull, notBlank, length, max, min, id}

    Type[] validateType() default {Type.notNull};

}
