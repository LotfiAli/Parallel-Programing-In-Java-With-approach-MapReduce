package IO.extensionParser.string;

import IO.core.parser.MetaDataObject;
import IO.core.parserWrapper.ParserCell;

/**
 * Created by alotfi on 6/6/2016.
 */
public class StringParseCell implements ParserCell {
    private String value;
    private StringBuilder row;
    private MetaDataObject metaDataObject;

    public StringParseCell(String cell) {
        this.value = cell;
    }

    public StringParseCell(StringBuilder row, MetaDataObject metaDataObject) {
        this.row = row;
        this.metaDataObject = metaDataObject;
    }

    public Object getCellValue() {
        return value;
    }

    public void create() {
        row.append(metaDataObject.getValuePrimitive());
    }
}
