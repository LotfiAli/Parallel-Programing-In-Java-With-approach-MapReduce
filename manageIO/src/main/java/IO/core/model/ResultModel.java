package IO.core.model;


import IO.core.validation.ValidationResult;

/**
 * Created by alotfi on 7/17/2016.
 */
public class ResultModel {
    private ValidationResult validationResult;
    private Object resultModel;

    public ResultModel() {
    }

    public ValidationResult getValidationResult() {
        return validationResult;
    }

    public void setValidationResult(ValidationResult validationResult) {
        this.validationResult = validationResult;
    }

    public <T> T getResultModel() {
        return (T) resultModel;
    }

    public void setResultModel(Object resultModel) {
        this.resultModel = resultModel;
    }

}
