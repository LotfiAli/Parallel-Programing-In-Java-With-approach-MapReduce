package IO.core.base;


import IO.core.exception.BaseExcelParserException;
import IO.core.model.ResultModel;
import IO.core.parser.MetaDataObject;
import IO.core.parser.metaDataParser.BaseMetaDataParserImpl;
import IO.core.parserWrapper.ParserFile;
import IO.core.readExcelFile.DeSerializeFile;
import IO.core.readExcelFile.DefaultSerializeDeserialize;
import IO.core.readExcelFile.SerializeFile;

/**
 * Created by alotfi on 5/24/2016.
 */
public class ParserManagerImpl implements ParserManager {

    private String pathFile;
    private Class typeClass;
    private ParserFile parserFile;

    public ParserManagerImpl(Class typeClass, ParserFile parserFile) {
        this.typeClass = typeClass;
        this.parserFile = parserFile;
    }

    public ResultModel deSerialize() throws BaseExcelParserException {
        return deSerialize(new DefaultSerializeDeserialize());
    }

    public ResultModel deSerialize(DeSerializeFile deSerializeFile) throws BaseExcelParserException {
        MetaDataObject metaDataObject = BaseMetaDataParserImpl.getMetaData(this.typeClass, null);
        return deSerializeFile.deserializeFile(metaDataObject, typeClass, parserFile);
    }

    public void serialize(Object value) throws BaseExcelParserException {
        serialize(value, new DefaultSerializeDeserialize());
    }

    public void serialize(Object value, SerializeFile serializeFile) throws BaseExcelParserException {
        MetaDataObject metaDataObject = BaseMetaDataParserImpl.getMetaData(this.typeClass, value);
        serializeFile.serializeFile(metaDataObject, parserFile);
    }

}
