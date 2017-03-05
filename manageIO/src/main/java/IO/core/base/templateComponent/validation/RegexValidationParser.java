package IO.core.base.templateComponent.validation;







import IO.core.annotation.validation.RegexValidation;

import java.lang.annotation.Annotation;

/**
 * Created by alotfi on 11/8/2016.
 */
public class RegexValidationParser extends ValidationBase {

    public RegexValidationParser() {
        super(RegexValidation.class);
    }

    @Override
    protected String execute(Object value, String filedName) {
        return null;
    }


    public ExecuteValidation executeValidation(Annotation annotation)
    {
        return null;
    }
}
