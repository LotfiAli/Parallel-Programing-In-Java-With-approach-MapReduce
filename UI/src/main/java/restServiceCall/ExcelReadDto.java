package restServiceCall;

import IO.core.annotation.column.ColumnTitel;
import IO.core.annotation.converter.ConvertTo;
import IO.core.annotation.validation.NotNullValidation;
import IO.core.parser.TypeObject;

/**
 * Created by alotfi on 3/4/2017.
 */
public class ExcelReadDto {

    @ConvertTo(convertTo = TypeObject.STRING)
    @NotNullValidation()
//    @ColorHeader(blue = 100,green = 10,red = 60)
    @ColumnTitel(TitelName = "ضبا")
    private String sheba;


    @ConvertTo(convertTo = TypeObject.STRING)
    @NotNullValidation()
//    @ColorHeader(blue = 100,green = 10,red = 60)
    @ColumnTitel(TitelName = "ردیف")
    private String state;


    @ConvertTo(convertTo = TypeObject.STRING)
    @NotNullValidation()
//    @ColorHeader(blue = 100,green = 10,red = 60)
    @ColumnTitel(TitelName = "ردیف")
    private String result;


    public ExcelReadDto() {
    }

    public ExcelReadDto(String sheba, String state, String result) {
        this.sheba = sheba;
        this.state = state;
        this.result = result;
    }

    public String getSheba() {
        return sheba;
    }

    public void setSheba(String sheba) {
        this.sheba = sheba;
    }

    public String getRow() {
        return state;
    }

    public void setRow(String row) {
        this.state = row;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
