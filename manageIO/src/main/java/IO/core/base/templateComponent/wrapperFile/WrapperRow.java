package IO.core.base.templateComponent.wrapperFile;


import IO.core.exception.BaseExcelParserException;
import IO.core.parserWrapper.ParserRow;

import java.util.List;

/**
 * Created by alotfi on 5/25/2016.
 */
public class WrapperRow {
    //    private Row row;
    private List<WrapperCell> cellWrappers;
    private ParserRow parserRow;

    public WrapperRow(ParserRow parserRow) {
        this.parserRow = parserRow;
        cellWrappers = this.parserRow.getCells();
    }

    public WrapperCell getCellOfRowById(int index) {
        try {
            return cellWrappers.get(index);
        } catch (Exception e) {
            return parserRow.createWrapperEmpty();
        }
    }

    public void read() throws BaseExcelParserException {
    }

    public int getRowNumber() {
        return this.parserRow.rowNumber();
    }

    public String getRowData() {
        return parserRow.getRowValueString().toString();
    }

}
