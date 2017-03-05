package IO.core.parser.parsersAnnotation.cell;

import IO.core.annotation.cell.BorderRight;
import IO.core.parser.MetaDataObject;
import IO.core.parser.parsersAnnotation.BaseParser;

import java.lang.reflect.Field;

/**
 * Created by alotfi on 12/7/2016.
 */
public class BoredrRightParser extends BaseParser {
    @Override
    public void parse(MetaDataObject metaDataObject, Field field) {
        BorderRight column = getAnnotation(BorderRight.class, field);
        if (column != null) {
            metaDataObject.setBorderCellRight(column.BOrderCell());
        }
    }
}
