package IO.core.parser.parsersAnnotation;

import IO.core.parser.MetaDataObject;

import java.lang.reflect.Field;

/**
 * Created by alotfi on 5/24/2016.
 */
public interface ParsersElement {
    void parse(MetaDataObject metaDataObject, Field field);
}
