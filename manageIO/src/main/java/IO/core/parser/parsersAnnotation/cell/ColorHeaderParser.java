package IO.core.parser.parsersAnnotation.cell;

import IO.core.annotation.cell.ColorHeader;
import IO.core.parser.MetaDataObject;
import IO.core.parser.parsersAnnotation.BaseParser;

import java.lang.reflect.Field;

/**
 * Created by alotfi on 12/6/2016.
 */
public class ColorHeaderParser extends BaseParser {
    @Override
    public void parse(MetaDataObject metaDataObject, Field field) {
        ColorHeader column = getAnnotation(ColorHeader.class, field);
        if (column != null) {
            metaDataObject.setRedHeader(column.red());
            metaDataObject.setBlueHeader(column.blue());
            metaDataObject.setGreenHeader(column.green());
        }
    }
}
