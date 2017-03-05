package IO.core.parserWrapper;

import IO.core.base.templateComponent.wrapperFile.WrapperCell;

import java.util.List;

/**
 * Created by alotfi on 6/6/2016.
 */
public interface ParserRow {
    List<WrapperCell> getCells();
    void create();
    int rowNumber();
    Object getRowValueString();
    WrapperCell createWrapperEmpty();

}
