package IO.core.annotation.converter;





import IO.core.parser.TypeObject;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by alotfi on 5/24/2016.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface ConvertTo {
    TypeObject convertTo() default TypeObject.STRING;
}
