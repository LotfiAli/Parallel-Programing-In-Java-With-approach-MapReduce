package test;



import IO.core.annotation.cell.BORDER_CELL;
import IO.core.annotation.cell.BorderRight;
import IO.core.annotation.column.StartColumn;
import IO.core.annotation.row.IndexRow;
import IO.core.annotation.row.TitleHolder;
import IO.core.annotation.sheet.Sheet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alotfi on 5/24/2016.
 */
public class MessageExcel {

    public MessageExcel() {
        message=new ArrayList<Body>();

    }




    @Sheet(name = "test1")
    @StartColumn(Start = 0)
    private List<Body> message;

    public List<Body> getMessage() {
        return message;
    }

    public void setMessage(List<Body> message) {
        this.message = message;
    }
//
//    public String getTitel() {
//        return titel;
//    }
//
//    public void setTitel(String titel) {
//        this.titel = titel;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getFamily() {
//        return family;
//    }
//
//    public void setFamily(String family) {
//        this.family = family;
//    }

    //
//    @Override
//    public String toString() {
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append(System.getProperty("line.separator"));
//        stringBuilder.append("************sheet 1**************");
//        stringBuilder.append(System.getProperty("line.separator"));
////        for (Header h : header) {
//        stringBuilder.append(header.getName() + "              " + header.getFamily());
//        stringBuilder.append(System.getProperty("line.separator"));
////        }
//        stringBuilder.append("************sheet2******************");
//        stringBuilder.append(System.getProperty("line.separator"));
//        for (Body body : message) {
//            stringBuilder.append(body.getName() + "              " + body.getFamily() + "             " + body.getOld());
//            stringBuilder.append(System.getProperty("line.separator"));
//        }
//        return stringBuilder.toString();
//
//    }
}
