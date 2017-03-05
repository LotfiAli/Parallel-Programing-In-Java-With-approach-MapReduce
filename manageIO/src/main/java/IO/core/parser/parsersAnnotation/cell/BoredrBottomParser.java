package IO.core.parser.parsersAnnotation.cell;


import IO.core.annotation.cell.BoredrBottom;
import IO.core.parser.MetaDataObject;
import IO.core.parser.parsersAnnotation.BaseParser;

import java.lang.reflect.Field;

/**
 * Created by alotfi on 12/7/2016.
 */
public class BoredrBottomParser extends BaseParser {
    @Override
    public void parse(MetaDataObject metaDataObject, Field field) {
        BoredrBottom column = getAnnotation(BoredrBottom.class, field);
        if (column != null) {
            metaDataObject.setBorderCellBottom(column.BOrderCell());
        }
    }
}
