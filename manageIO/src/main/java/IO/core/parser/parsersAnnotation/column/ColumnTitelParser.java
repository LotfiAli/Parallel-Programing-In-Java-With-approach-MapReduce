package IO.core.parser.parsersAnnotation.column;

import IO.core.annotation.column.ColumnTitel;
import IO.core.parser.MetaDataObject;
import IO.core.parser.parsersAnnotation.BaseParser;

import java.lang.reflect.Field;

/**
 * Created by alotfi on 12/7/2016.
 */
public class ColumnTitelParser extends BaseParser {
    @Override
    public void parse(MetaDataObject metaDataObject, Field field) {
        ColumnTitel column = getAnnotation(ColumnTitel.class, field);
        if (column != null)
            metaDataObject.setColumnTitel(column.TitelName());
    }
}
