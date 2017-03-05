package IO.extensionParser.excel;

import IO.core.base.templateComponent.wrapperFile.WrapperCell;
import IO.core.parser.MetaDataObject;
import IO.core.parserWrapper.ParserRow;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by alotfi on 6/6/2016.
 */
public class ExcelParserRow implements ParserRow {

    List<WrapperCell> cellWrappers;
    private Row row;
    private MetaDataObject metaDataObject;
    private XSSFWorkbook xssfWorkbook;
    private XSSFSheet spreadsheet;
    private int index;

    public ExcelParserRow(Row row) {
        this.row = row;
    }

    public ExcelParserRow(XSSFWorkbook xssfWorkbook, XSSFSheet spreadsheet, MetaDataObject metaDataObject, int index) {
        this.xssfWorkbook = xssfWorkbook;
        this.spreadsheet = spreadsheet;
        this.index = index;
        this.metaDataObject = metaDataObject;
    }

    public List<WrapperCell> getCells() {
        cellWrappers = new ArrayList<WrapperCell>();
        Iterator<Cell> cellIterator = row.iterator();
        while (cellIterator.hasNext()) {
            Cell cell = cellIterator.next();
            cellWrappers.add(new WrapperCell(new ExcelParseCell(cell)));
        }
        return cellWrappers;
    }

    public void create() {
        cellWrappers = new ArrayList<WrapperCell>();
        Row row = this.spreadsheet.createRow(this.index);
        int point = 0;
        if (metaDataObject.getMetaDataObjects() != null && metaDataObject.getMetaDataObjects().size() > 0) {
            for (MetaDataObject cellValue : metaDataObject.getMetaDataObjects())
                createCell(row, point++, cellValue);
        } else
            createCell(row, point, metaDataObject);
    }

    private void createCell(Row row, Integer point, MetaDataObject cellValue) {
        ExcelParseCell cell = new ExcelParseCell(spreadsheet, xssfWorkbook, row, cellValue, false, point++);
        cell.create();
//        return point;
    }


    public int rowNumber() {
        return 0;
    }


    public Object getRowValueString() {
        return null;
    }


    public WrapperCell createWrapperEmpty() {
        return null;
    }
}
