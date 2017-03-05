package IO.extensionParser.excel;

import IO.core.base.templateComponent.wrapperFile.WrapperRow;
import IO.core.parser.MetaDataObject;
import IO.core.parserWrapper.ParserBody;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by alotfi on 6/6/2016.
 */
public class ExcelParserBody implements ParserBody {

    private XSSFWorkbook xssfWorkbook;
    private XSSFSheet sheet;
    private List<MetaDataObject> metaDataObjects;
    private int index;

    public ExcelParserBody(XSSFSheet sheet) {
        this.sheet = sheet;
    }

    public ExcelParserBody(XSSFWorkbook xssfWorkbook, XSSFSheet sheet, List<MetaDataObject> metaDataObjects, int index) {
        this.xssfWorkbook = xssfWorkbook;
        this.sheet = sheet;
        this.metaDataObjects = metaDataObjects;
        this.index=index;
    }

    public List<WrapperRow> getBody() {
        List<WrapperRow> bodyRows = new ArrayList<WrapperRow>();
        Iterator<Row> rowIterator = sheet.iterator();
        rowIterator.next();//For Header Sheet
        while (rowIterator.hasNext())
            bodyRows.add(new WrapperRow(new ExcelParserRow(rowIterator.next())));
        return bodyRows;
    }

    public void create() {
//        List<WrapperRow> bodyRows = new ArrayList<WrapperRow>();
//        int index =  metaDataObjects.getStartRowIndx();;
        for (MetaDataObject rows : metaDataObjects) {
//            index=rows.getStartRowIndx();
            ExcelParserRow parserRow = new ExcelParserRow(xssfWorkbook,sheet, rows, index++);
            parserRow.create();
//            bodyRows.add(new WrapperRow(parserRow));
        }
    }
}
