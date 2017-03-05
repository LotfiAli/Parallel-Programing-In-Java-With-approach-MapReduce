package IO.core.parser.parsersAnnotation.row;

import IO.core.annotation.row.TitleHolder;
import IO.core.parser.MetaDataObject;
import IO.core.parser.parsersAnnotation.BaseParser;

import java.lang.reflect.Field;

/**
 * Created by alotfi on 12/4/2016.
 */

public class TitleHolderParser extends BaseParser {
    @Override
    public void parse(MetaDataObject metaDataObject, Field field) {
        TitleHolder titleHolder = getAnnotation(TitleHolder.class, field);
        if (titleHolder != null)
            metaDataObject.setTitleHolder(titleHolder.HaveHolder());
    }
}
