package IO.core.base.templateComponent.validation;


import IO.core.annotation.validation.LengthValidation;
import IO.core.annotation.validation.TYPE_OPERATION;

import java.lang.annotation.Annotation;

/**
 * Created by alotfi on 11/8/2016.
 */
public class LengthValidationParser extends ValidationBase {

    public static final String FIELD_VALUE_IS_LESS_THAN_THE_LIMIT = "مقدار فیلد کمتر از حد مجاز است";
    private static final String FIELD_VALUE_IS_EXCEEDED = "مقدار فیلد بیش از حد مجاز است";
    private static final String ERROR_IN_LEN = "خطا در طول فیلد";

    private long targetLength;
    private TYPE_OPERATION typeOperation;

    public LengthValidationParser() {
        super(LengthValidation.class);
    }

    public LengthValidationParser(long length, TYPE_OPERATION typeOperation) {
        this.targetLength = length;
        this.typeOperation = typeOperation;
    }

    @Override
    protected String execute(Object value, String filedName) {
        if (value == null || "".equals(value.toString()))
            return null;
        int lengthValue = value.toString().length();
        switch (typeOperation) {
            case BIGGER:
                if (lengthValue < targetLength)
                    return " طول  فیلد" + filedName + "کمتر از  " + targetLength + "کاراکتر است ";
//                    return FIELD_VALUE_IS_LESS_THAN_THE_LIMIT;
            case SMALLER:
                if (lengthValue > targetLength)
                    return " طول  فیلد" + filedName + "بیشتر از  " + targetLength + "کاراکتر است ";
            case SMALLER_EQUAL:
                if (!(lengthValue <= targetLength))
                    return " طول  فیلد" + filedName + "بیشتر از  " + targetLength + "کاراکتر است ";
                break;
            case BIGGER_EQUAL:
                if (!(lengthValue >= targetLength))
                    return " طول  فیلد" + filedName + "کمتر از  " + targetLength + "کاراکتر است ";
                break;
            case EQUAL:
                if ((lengthValue != this.targetLength))
                    return " طول فیلد" + filedName + "باید" + targetLength + "کاراکتر باشد";
        }
        return null;
    }


    public ExecuteValidation executeValidation(Annotation annotation) {
        LengthValidation lengthValidation = (LengthValidation) annotation;
        return new LengthValidationParser(lengthValidation.Length(), lengthValidation.TypeOperation());
    }
}
