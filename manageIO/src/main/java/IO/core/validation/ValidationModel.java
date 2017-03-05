package IO.core.validation;

import java.util.List;

/**
 * Created by alotfi on 7/16/2016.
 */
public interface ValidationModel {
    List<String> isValid() throws Exception;
}
