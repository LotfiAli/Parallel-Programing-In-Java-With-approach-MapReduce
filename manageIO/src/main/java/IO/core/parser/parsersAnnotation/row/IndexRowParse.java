package IO.core.parser.parsersAnnotation.row;

import IO.core.annotation.row.IndexRow;
import IO.core.parser.MetaDataObject;
import IO.core.parser.parsersAnnotation.BaseParser;

import java.lang.reflect.Field;

/**
 * Created by alotfi on 12/4/2016.
 */
public class IndexRowParse extends BaseParser {
    @Override
    public void parse(MetaDataObject metaDataObject, Field field) {
        IndexRow sheet = getAnnotation(IndexRow.class, field);
        if (sheet != null)
            metaDataObject.setStartRowIndx(sheet.Index());
    }

}
