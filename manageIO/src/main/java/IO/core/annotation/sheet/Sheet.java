package IO.core.annotation.sheet;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by alotfi on 5/24/2016.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Sheet {
    String name();
}
