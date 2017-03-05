package IO.core.base;

import IO.core.exception.BaseExcelParserException;
import IO.core.model.ResultModel;
import IO.core.readExcelFile.DeSerializeFile;
import IO.core.readExcelFile.SerializeFile;

/**
 * Created by alotfi on 5/24/2016.
 */
public interface ParserManager {

     ResultModel deSerialize() throws Exception;

     ResultModel deSerialize(DeSerializeFile deSerializeFile) throws BaseExcelParserException;

    void serialize(Object value, SerializeFile serializeFile) throws BaseExcelParserException;

    void serialize(Object value) throws Exception;


}
