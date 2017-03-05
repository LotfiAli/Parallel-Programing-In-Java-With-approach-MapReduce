package IO.core.parserWrapper;


import IO.core.base.templateComponent.wrapperFile.WrapperRow;
import IO.core.exception.IOExcelException;

import java.util.List;

/**
 * Created by alotfi on 6/6/2016.
 */
public interface ParserBody {
    List<WrapperRow> getBody() throws IOExcelException;
    void create();
}
