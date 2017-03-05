package IO.core.parser.parsersAnnotation.cell;

import IO.core.annotation.cell.SpamCell;
import IO.core.parser.MetaDataObject;
import IO.core.parser.parsersAnnotation.BaseParser;

import java.lang.reflect.Field;

/**
 * Created by alotfi on 12/5/2016.
 */
public class SpamCellParser extends BaseParser {
    @Override
    public void parse(MetaDataObject metaDataObject, Field field) {
        SpamCell column = getAnnotation(SpamCell.class, field);
        if (column != null) {
            metaDataObject.setSpamCell(column.SpamCell());
        }
    }
}
