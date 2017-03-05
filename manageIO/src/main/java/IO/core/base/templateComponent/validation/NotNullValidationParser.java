package IO.core.base.templateComponent.validation;


import IO.core.annotation.validation.NotNullValidation;

import java.lang.annotation.Annotation;

/**
 * Created by alotfi on 5/24/2016.
 */
public class NotNullValidationParser extends ValidationBase {

    public NotNullValidationParser() {
        super(NotNullValidation.class);
    }

    @Override
    protected String execute(Object value, String filedName) {
        if (value != null && "".equals(value.toString()) )
//            return  "خالی است"+filedName+
            return  "فیلد" +filedName+"فاقد مقدار است";
        return null;
    }


    public ExecuteValidation executeValidation(Annotation annotation) {
        return new NotNullValidationParser();
    }
}
