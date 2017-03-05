package IO.core.parserWrapper;

import IO.core.base.templateComponent.wrapperFile.WrapperBody;
import IO.core.base.templateComponent.wrapperFile.WrapperHeader;
import IO.core.exception.IOExcelException;

/**
 * Created by alotfi on 6/6/2016.
 */
public interface ParserSheet {
    WrapperHeader getHeader() throws IOExcelException;
    WrapperBody getBody() throws IOExcelException;
    String getName();
    void create() throws IOExcelException;


}
