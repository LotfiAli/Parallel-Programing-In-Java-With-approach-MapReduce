package test;



import IO.core.annotation.cell.*;
import IO.core.annotation.column.ColumnTitel;
import IO.core.annotation.converter.ConvertTo;
import IO.core.annotation.validation.NotNullValidation;
import IO.core.parser.TypeObject;

import java.util.List;

/**
 * Created by alotfi on 5/24/2016.
 */
public class Body {

    @ConvertTo(convertTo = TypeObject.STRING)
    @NotNullValidation()
//    @ColorHeader(blue = 100,green = 10,red = 60)
    @ColumnTitel(TitelName = "نام")
    private String name;

    @ConvertTo(convertTo = TypeObject.STRING)
    @NotNullValidation()
//    @ColorHeader(blue = 100,green = 10,red = 60)

    @ColumnTitel(TitelName = " نام خانوادگی")
    private String family;


    @ConvertTo(convertTo = TypeObject.STRING)
//    @ColorHeader(blue = 100,green = 10,red = 60)
    @ColumnTitel(TitelName = "سن")
    private String old;

//    @ConvertTo(convertTo = TypeObject.STRING)
//    @NotNullValidation()
//    @ColorHeader(blue = 100,green = 10,red = 60)
//    @BorderRight(BOrderCell = BORDER_CELL.BORDER_MEDIUM)
//    @BorderUp(BOrderCell = BORDER_CELL.BORDER_MEDIUM)
//    @BoredrBottom(BOrderCell = BORDER_CELL.BORDER_MEDIUM)
//    @BorderLeft(BOrderCell = BORDER_CELL.BORDER_MEDIUM)
//    @ColumnTitel(TitelName = "فامیلی")
//    private String family1;
//
//    @BorderRight(BOrderCell = BORDER_CELL.BORDER_MEDIUM)
//    @BorderUp(BOrderCell = BORDER_CELL.BORDER_MEDIUM)
//    @BoredrBottom(BOrderCell = BORDER_CELL.BORDER_MEDIUM)
//    @BorderLeft(BOrderCell = BORDER_CELL.BORDER_MEDIUM)
//    @ConvertTo(convertTo = TypeObject.Long)
//    @ColorHeader(blue = 100,green = 10,red = 60)
//    @ColorCell(blue = 100,green = 10,red = 60)
//    @ColumnTitel(TitelName = "سن واقعی")
//    private long old1;


//    public Body(String name, String family, String old, String family1, long old1) {
//        this.name = name;
//        this.family = family;
//        this.old = old;
////        this.family1 = family1;
////        this.old1 = old1;
//    }


    public Body() {
    }

    public Body(String name, String family, String old) {
        this.name = name;
        this.family = family;
        this.old = old;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getOld() {
        return old;
    }

    public void setOld(String old) {
        this.old = old;
    }

//    public String getFamily1() {
//        return family1;
//    }
//
//    public void setFamily1(String family1) {
//        this.family1 = family1;
//    }
//
//    public long getOld1() {
//        return old1;
//    }
//
//    public void setOld1(long old1) {
//        this.old1 = old1;
//    }
}
