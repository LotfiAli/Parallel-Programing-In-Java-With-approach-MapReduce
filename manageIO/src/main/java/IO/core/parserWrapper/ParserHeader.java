package IO.core.parserWrapper;

import IO.core.base.templateComponent.wrapperFile.WrapperHeader;
import IO.core.exception.IOExcelException;

/**
 * Created by alotfi on 6/7/2016.
 */
public interface ParserHeader {
    WrapperHeader getHeader() throws IOExcelException;
    void create();
}
