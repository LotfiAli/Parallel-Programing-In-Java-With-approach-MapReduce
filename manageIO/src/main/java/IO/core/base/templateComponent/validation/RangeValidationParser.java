package IO.core.base.templateComponent.validation;


import IO.core.annotation.validation.RangeValidation;

import java.lang.annotation.Annotation;

/**
 * Created by alotfi on 11/8/2016.
 */
public class RangeValidationParser extends ValidationBase {

    private static final String ERROR_IN_READ_FILED = "مشکل در خواندن فیلد ";
    private static final String VALUE_IS_NOT_IN_RANGE_MIN_MAX = "در بازه تعریف شده قرار ندارد فیلد";

    private long min;
    private long max;

    public RangeValidationParser() {
        super(RangeValidation.class);
    }

    public RangeValidationParser(long min, long max) {
        this.min = min;
        this.max = max;
    }

    @Override
    protected String execute(Object value, String filedName) {
        long v;
        if(value==null || "".equals(value.toString()))
            return null;
        try {
            v = Long.parseLong(value.toString());
        } catch (Exception e) {
            return  filedName+ ERROR_IN_READ_FILED ;        }
        if ((v < min ))
            return " حداقل مبلغ قابل پرداخت"+min+   "ریال می باشد";
       if(v > max)
           return " حداکثر مبلغ قابل پرداخت"+max+ "ريال مي باشد ";
        return null;
    }

    public ExecuteValidation executeValidation(Annotation annotation) {
        RangeValidation rangeValidation = (RangeValidation) annotation;
        return new RangeValidationParser(rangeValidation.Min(), rangeValidation.Max());
    }
}
