package IO.core.annotation.cell;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by alotfi on 12/4/2016.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface SpamCell {
    int SpamCell() default 1;
}
