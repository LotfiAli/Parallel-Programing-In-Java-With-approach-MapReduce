package IO.core.parser.parsersAnnotation.cell;


import IO.core.annotation.cell.BorderLeft;
import IO.core.parser.MetaDataObject;
import IO.core.parser.parsersAnnotation.BaseParser;

import java.lang.reflect.Field;

/**
 * Created by alotfi on 12/7/2016.
 */
public class BoredrLeftParser extends BaseParser {
    @Override
    public void parse(MetaDataObject metaDataObject, Field field) {
        BorderLeft column = getAnnotation(BorderLeft.class, field);
        if (column != null) {
            metaDataObject.setBorderCellLeft(column.BOrderCell());
        }
    }
}
