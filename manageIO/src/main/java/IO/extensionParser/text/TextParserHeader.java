package IO.extensionParser.text;

import IO.core.base.templateComponent.wrapperFile.WrapperHeader;
import IO.core.exception.IOExcelException;
import IO.core.parser.MetaDataObject;
import IO.core.parserWrapper.ParserHeader;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by alotfi on 6/7/2016.
 */
public class TextParserHeader implements ParserHeader {

    private MetaDataObject metaDataObjects;
    private BufferedReader contentFile;
    private StringBuilder result;

    public TextParserHeader(BufferedReader contentFile) {
        this.contentFile = contentFile;
    }

    public TextParserHeader(StringBuilder contentFile, MetaDataObject metaDataObjects) {
        this.result = contentFile;
        this.metaDataObjects = metaDataObjects;
    }

    public WrapperHeader getHeader() throws IOExcelException {
        try {
            return new WrapperHeader(new TextParserRow(contentFile.readLine()));
        } catch (IOException e) {
            throw new IOExcelException("error in parse body", e);
        }
    }

    public void create() {
        TextParserRow parserRow = new TextParserRow(result, this.metaDataObjects);
        parserRow.create();
        result.append(System.getProperty("line.separator"));
    }
}
