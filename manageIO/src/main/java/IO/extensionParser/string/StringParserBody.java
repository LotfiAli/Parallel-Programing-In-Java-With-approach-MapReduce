package IO.extensionParser.string;

import IO.core.base.templateComponent.wrapperFile.WrapperRow;
import IO.core.exception.IOExcelException;
import IO.core.parser.MetaDataObject;
import IO.core.parserWrapper.ParserBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alotfi on 6/6/2016.
 */
public class StringParserBody implements ParserBody {

    private List<MetaDataObject> metaDataObjects;
    private List<String> contentFile;
    private int index;
    private StringBuilder result;


    public StringParserBody(List<String> contentFile, int indx) {
        this.contentFile = contentFile;
        this.index = indx;
    }

    public StringParserBody(StringBuilder contentFile, List<MetaDataObject> metaDataObjects) {
        this.result = contentFile;
        this.metaDataObjects = metaDataObjects;
    }

    public List<WrapperRow> getBody() throws IOExcelException {
        List<WrapperRow> bodyRows = new ArrayList<WrapperRow>();
        int rowNumber = this.index;
//            contentFile.readLine();
        for (String sCurrentLine : contentFile) {
            rowNumber++;
            bodyRows.add(new WrapperRow(new StringParserRow(sCurrentLine, rowNumber)));
        }
        return bodyRows;
    }

    public void create() {
        for (MetaDataObject rows : metaDataObjects) {
            StringParserRow parserRow = new StringParserRow(result, rows);
            parserRow.create();
            result.append(System.getProperty("line.separator"));
        }
    }
}
