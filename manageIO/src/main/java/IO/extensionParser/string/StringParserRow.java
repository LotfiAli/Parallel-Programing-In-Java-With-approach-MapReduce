package IO.extensionParser.string;


import IO.core.base.templateComponent.wrapperFile.WrapperCell;
import IO.core.parser.MetaDataObject;
import IO.core.parserWrapper.ParserRow;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alotfi on 6/6/2016.
 */
public class StringParserRow implements ParserRow {

    List<WrapperCell> cellWrappers;
    private String row;
    private MetaDataObject metaDataObject;
    private StringBuilder spreadsheet;
    private int rowNumber;

    public StringParserRow(String row, int index) {
        this.row = row;
        this.rowNumber = index;
    }


    public StringParserRow(StringBuilder spreadsheet, MetaDataObject metaDataObject) {
        this.spreadsheet = spreadsheet;
        this.metaDataObject = metaDataObject;
    }

    public List<WrapperCell> getCells() {
        cellWrappers = new ArrayList<WrapperCell>();
        String[] cellIterator = row.split(",");
        for (String cellValue : cellIterator) {
            cellWrappers.add(new WrapperCell(new StringParseCell(cellValue)));
        }
        return cellWrappers;
    }

    public void create() {
        cellWrappers = new ArrayList<WrapperCell>();
        StringBuilder row = new StringBuilder();
        List<MetaDataObject> metaDataObjects = metaDataObject.getMetaDataObjects();
        for (int i = 0; i <= metaDataObjects.size() - 1; i++) {
            MetaDataObject cellValue = metaDataObjects.get(i);
            StringParseCell cell = new StringParseCell(row, cellValue);
            cell.create();
            if (i < metaDataObjects.size() - 1)
                row.append(",");
        }
        spreadsheet.append(row.toString());
    }

    public int rowNumber() {
        return rowNumber;
    }


    public Object getRowValueString() {
        String result = "";
        for (WrapperCell wrapperCell : cellWrappers) {
            result += wrapperCell.getCellValue().toString();
            result +=",";
        }
        return result;
    }

    @Override
    public WrapperCell createWrapperEmpty() {
        return new WrapperCell(new StringParseCell(""));
    }
}
