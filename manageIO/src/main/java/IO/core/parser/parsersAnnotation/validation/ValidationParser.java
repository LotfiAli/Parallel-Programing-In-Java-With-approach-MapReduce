package IO.core.parser.parsersAnnotation.validation;

import IO.core.base.templateComponent.validation.*;
import IO.core.parser.MetaDataObject;
import IO.core.parser.parsersAnnotation.CollectionValidationBase;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alotfi on 5/24/2016.
 */
public class ValidationParser extends CollectionValidationBase<ExecuteValidation> {

    private static final String VALIDATION = "Validation";
    private final static ArrayList<CanExecuteValidation> EXECUTE_VALIDATIONs = new ArrayList<CanExecuteValidation>();

    static {
        EXECUTE_VALIDATIONs.add(new LengthValidationParser());
        EXECUTE_VALIDATIONs.add(new NotNullValidationParser());
        EXECUTE_VALIDATIONs.add(new RangeValidationParser());
        EXECUTE_VALIDATIONs.add(new RegexValidationParser());
        EXECUTE_VALIDATIONs.add(new AccountValidationParser());
    }

    @Override
    protected void addToMetaDataObject(List<ExecuteValidation> parsers, MetaDataObject metaDataObject) {
        metaDataObject.setValidations(parsers);
    }

    @Override
    protected ExecuteValidation createParseForAnnotation(Annotation annotation) {
        if (checkConstraint(annotation))
            return createValidation(annotation);
        return null;
    }

    @Override
    protected Boolean checkConstraintAnnotation(Annotation annotation) {
        return checkConstraint(annotation);
    }

    private Boolean checkConstraint(Annotation annotation) {
        String annotationName = getNameAnnotation(annotation);
        return (annotationName.contains(VALIDATION));
    }

    private ExecuteValidation createValidation(Annotation annotation) {
        for (CanExecuteValidation item : EXECUTE_VALIDATIONs)
            if (item.canExecuteValidation(annotation))
                return item.executeValidation(annotation);
        return null;
    }
}
