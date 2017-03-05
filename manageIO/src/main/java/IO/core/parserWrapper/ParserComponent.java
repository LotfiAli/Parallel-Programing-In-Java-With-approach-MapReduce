package IO.core.parserWrapper;

import IO.core.exception.BaseExcelParserException;
import IO.core.parser.MetaDataObject;

/**
 * Created by alotfi on 6/5/2016.
 */
public interface ParserComponent {
    void parse(MetaDataObject metaDataObject) throws BaseExcelParserException;

    void create(MetaDataObject metaDataObject) throws BaseExcelParserException;
}
