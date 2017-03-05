package test;


import IO.core.annotation.column.DescriptionColumn;
import IO.core.annotation.converter.ConvertTo;
import IO.core.annotation.validation.NotNullValidation;
import IO.core.parser.TypeObject;

/**
 * Created by alotfi on 7/12/2016.
 */
public class BodyString {
    @DescriptionColumn(description = "test6")
    @ConvertTo(convertTo = TypeObject.Long)
    @NotNullValidation()
    private double amount;
    @DescriptionColumn(description = "test7")
    @ConvertTo(convertTo = TypeObject.STRING)
    @NotNullValidation()
    private String accNumDst;
    @DescriptionColumn(description = "test8")
        @ConvertTo(convertTo = TypeObject.STRING)
    @NotNullValidation()
    private String additionalDate;

    public BodyString() {
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getAccNumDst() {
        return accNumDst;
    }

    public void setAccNumDst(String accNumDst) {
        this.accNumDst = accNumDst;
    }

    public String getAdditionalDate() {
        return additionalDate;
    }

    public void setAdditionalDate(String additionalDate) {
        this.additionalDate = additionalDate;
    }

    @Override
    public String toString() {
        return "BodyString{" +
                "amount=" + amount +
                ", accNumDst='" + accNumDst + '\'' +
                ", additionalDate='" + additionalDate + '\'' +
                '}';
    }
}
