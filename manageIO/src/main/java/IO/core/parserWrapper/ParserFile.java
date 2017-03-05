package IO.core.parserWrapper;

import IO.core.base.templateComponent.wrapperFile.WrapperSheet;
import IO.core.exception.BaseExcelParserException;
import IO.core.parser.MetaDataObject;

import java.util.List;

/**
 * Created by alotfi on 6/5/2016.
 */
public interface ParserFile {
    List<WrapperSheet> parse(MetaDataObject metaDataObject) throws BaseExcelParserException;
    void create(MetaDataObject metaDataObject) throws BaseExcelParserException;
}
