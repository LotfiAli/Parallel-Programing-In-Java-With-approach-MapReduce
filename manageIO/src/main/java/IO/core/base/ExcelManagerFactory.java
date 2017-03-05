package IO.core.base;



import IO.core.exception.BaseExcelParserException;
import IO.core.parserWrapper.ParserFile;
import IO.extensionParser.excel.ExcelParser;
import IO.extensionParser.text.TextParser;

import java.io.IOException;

/**
 * Created by alotfi on 5/24/2016.
 */
public final class ExcelManagerFactory {

    public static ParserManager getExcelParserManager(String pathFile, Class typeClass) {
        return new ParserManagerImpl(typeClass, new ExcelParser(pathFile));
    }

    public static ParserManager getFileParserManager(String pathFile, Class typeClass) throws BaseExcelParserException, IOException {
        return new ParserManagerImpl(typeClass, new TextParser(pathFile));
    }


    public static ParserManager getParserManager(Class typeClass, ParserFile parserFile) {
        return new ParserManagerImpl(typeClass, parserFile);
    }


}
