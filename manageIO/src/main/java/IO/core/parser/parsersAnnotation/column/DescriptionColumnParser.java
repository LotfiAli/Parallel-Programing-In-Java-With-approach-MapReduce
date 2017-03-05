package IO.core.parser.parsersAnnotation.column;

import IO.core.annotation.column.DescriptionColumn;
import IO.core.parser.MetaDataObject;
import IO.core.parser.parsersAnnotation.BaseParser;

import java.lang.reflect.Field;

/**
 * Created by alotfi on 7/16/2016.
 */
public class DescriptionColumnParser extends BaseParser {
    @Override
    public void parse(MetaDataObject metaDataObject, Field field) {
        DescriptionColumn column = getAnnotation(DescriptionColumn.class, field);
        if (column != null) {
            String description = column.description();
            metaDataObject.setDescriptionColumn(description);
        }
    }
}
