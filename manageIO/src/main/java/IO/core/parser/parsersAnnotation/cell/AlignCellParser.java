package IO.core.parser.parsersAnnotation.cell;

import IO.core.annotation.cell.AlignCell;
import IO.core.parser.MetaDataObject;
import IO.core.parser.parsersAnnotation.BaseParser;

import java.lang.reflect.Field;

/**
 * Created by alotfi on 12/6/2016.
 */
public class AlignCellParser extends BaseParser {
    @Override
    public void parse(MetaDataObject metaDataObject, Field field) {
        AlignCell column = getAnnotation(AlignCell.class, field);
        if (column != null) {
            metaDataObject.setAlign_cell(column.Align());
        }
    }
}
