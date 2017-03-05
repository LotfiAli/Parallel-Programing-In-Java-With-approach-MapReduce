package test;


import IO.core.annotation.cell.ColorCell;
import IO.core.annotation.column.DescriptionColumn;
import IO.core.annotation.converter.ConvertTo;
import IO.core.annotation.validation.NotNullValidation;
import IO.core.parser.TypeObject;

/**
 * Created by alotfi on 7/12/2016.
 */
public class HeaderString {
    @DescriptionColumn(description = "test3")
    @NotNullValidation()
    @ColorCell(blue = 100, green = 10, red = 250)
    private String accNum;

    @NotNullValidation()
    @DescriptionColumn(description = "test4")
    @ConvertTo(convertTo = TypeObject.INT)
    @ColorCell(blue = 200, green = 150, red = 80)
    private int totalCount;

    @NotNullValidation()
    @DescriptionColumn(description = "test5")
    @ColorCell(blue = 200, green = 150, red = 80)
    @ConvertTo(convertTo = TypeObject.Long)

    private double totalSuml;

//    @ConvertTo(convertTo = TypeObject.INT)
//    @NotNullValidation()
//    private Double old;

    public HeaderString() {
    }

    public String getAccNum() {
        return accNum;
    }

    public void setAccNum(String accNum) {
        this.accNum = accNum;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public Double getTotalSuml() {
        return totalSuml;
    }

    public void setTotalSuml(Double totalSuml) {
        this.totalSuml = totalSuml;
    }

}
