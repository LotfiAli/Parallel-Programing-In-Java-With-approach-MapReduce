package IO.core.readExcelFile;


import IO.core.exception.BaseExcelParserException;
import IO.core.model.ResultModel;
import IO.core.parser.MetaDataObject;
import IO.core.parserWrapper.ParserFile;

/**
 * Created by alotfi on 6/7/2016.
 */
public interface DeSerializeFile {
   ResultModel deserializeFile(MetaDataObject metaDataObject, Class typeResult, ParserFile parserFile) throws BaseExcelParserException;
}
