package IO.core.parser.metaDataParser;


import IO.core.exception.BaseExcelParserException;
import IO.core.parser.MetaDataObject;

import java.lang.reflect.Field;

/**
 * Created by alotfi on 6/5/2016.
 */
public interface BaseMetaDataParser {
    void parse(MetaDataObject metaDataObject, Field field, Object targetObject) throws BaseExcelParserException;
}
