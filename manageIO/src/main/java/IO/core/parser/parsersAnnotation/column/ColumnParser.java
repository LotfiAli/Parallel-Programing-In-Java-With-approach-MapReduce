package IO.core.parser.parsersAnnotation.column;


import IO.core.annotation.column.Column;
import IO.core.parser.MetaDataObject;
import IO.core.parser.parsersAnnotation.BaseParser;

import java.lang.reflect.Field;

/**
 * Created by alotfi on 5/24/2016.
 */
public class ColumnParser extends BaseParser {
    @Override
    public void parse(MetaDataObject metaDataObject, Field field) {
        Column column = getAnnotation(Column.class, field);
        if (column != null)
            metaDataObject.setColumn(column.Index());
    }
}
