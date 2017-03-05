package IO.core.parser.parsersAnnotation.sheet;

import IO.core.annotation.sheet.Sheet;
import IO.core.parser.MetaDataObject;
import IO.core.parser.parsersAnnotation.BaseParser;

import java.lang.reflect.Field;

/**
 * Created by alotfi on 5/24/2016.
 */
public class SheetParser extends BaseParser {
    @Override
    public void parse(MetaDataObject metaDataObject, Field field) {
        Sheet sheet = getAnnotation(Sheet.class, field);
        if (sheet != null)
            metaDataObject.setSheetName(sheet.name());
    }
}
