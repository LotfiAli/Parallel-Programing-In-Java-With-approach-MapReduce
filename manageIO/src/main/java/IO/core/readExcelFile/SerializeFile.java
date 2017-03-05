package IO.core.readExcelFile;


import IO.core.exception.BaseExcelParserException;
import IO.core.parser.MetaDataObject;
import IO.core.parserWrapper.ParserFile;

/**
 * Created by alotfi on 6/7/2016.
 */
public interface SerializeFile {
    void serializeFile(MetaDataObject metaDataObject, ParserFile parserFile) throws BaseExcelParserException;
}
