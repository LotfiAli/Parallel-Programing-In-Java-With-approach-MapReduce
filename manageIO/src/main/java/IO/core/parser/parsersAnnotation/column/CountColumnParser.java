package IO.core.parser.parsersAnnotation.column;

import IO.core.annotation.column.CountColumn;
import IO.core.parser.MetaDataObject;
import IO.core.parser.parsersAnnotation.BaseParser;

import java.lang.reflect.Field;

/**
 * Created by alotfi on 7/12/2016.
 */
public class CountColumnParser extends BaseParser {
    @Override
    public void parse(MetaDataObject metaDataObject, Field field) {
        CountColumn column = getAnnotation(CountColumn.class, field);
        if (column != null) {
            int count = column.count();
            metaDataObject.setCountColumn(count);
        }
    }
}
