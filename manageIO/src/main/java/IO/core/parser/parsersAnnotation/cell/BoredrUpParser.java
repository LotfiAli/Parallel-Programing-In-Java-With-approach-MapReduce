package IO.core.parser.parsersAnnotation.cell;

import IO.core.annotation.cell.BorderUp;
import IO.core.parser.MetaDataObject;
import IO.core.parser.parsersAnnotation.BaseParser;

import java.lang.reflect.Field;

/**
 * Created by alotfi on 12/7/2016.
 */
public class BoredrUpParser extends BaseParser {
    @Override
    public void parse(MetaDataObject metaDataObject, Field field) {
        BorderUp column = getAnnotation(BorderUp.class, field);
        if (column != null) {
            metaDataObject.setBorderCellTop(column.BOrderCell());
        }
    }
}
