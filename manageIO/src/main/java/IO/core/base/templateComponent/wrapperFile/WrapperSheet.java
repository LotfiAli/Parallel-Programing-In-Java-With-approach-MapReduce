package IO.core.base.templateComponent.wrapperFile;


import IO.core.exception.IOExcelException;
import IO.core.parserWrapper.ParserSheet;

/**
 * Created by alotfi on 5/25/2016.
 */
public class WrapperSheet {

    private ParserSheet parserSheet;

    public WrapperSheet(ParserSheet parserSheet) {
        this.parserSheet = parserSheet;
    }

    public WrapperBody getBodyRows() throws IOExcelException {
        return parserSheet.getBody();
    }

    public String getSheetName() {
        return parserSheet.getName();
    }

    public void write() throws IOExcelException {
        parserSheet.create();
    }

    public WrapperHeader getHeaderRows() throws IOExcelException {
        return parserSheet.getHeader();
    }
}
