package IO.core.parser.parsersAnnotation.cell;

import IO.core.annotation.cell.ColorCell;
import IO.core.parser.MetaDataObject;
import IO.core.parser.parsersAnnotation.BaseParser;

import java.lang.reflect.Field;

/**
 * Created by alotfi on 6/8/2016.
 */
public class ColorParser extends BaseParser {
    @Override
    public void parse(MetaDataObject metaDataObject, Field field) {
        ColorCell column = getAnnotation(ColorCell.class, field);
        if (column != null) {
            metaDataObject.setRed(column.red());
            metaDataObject.setBlue(column.blue());
            metaDataObject.setGreen(column.green());
        }
    }
}
