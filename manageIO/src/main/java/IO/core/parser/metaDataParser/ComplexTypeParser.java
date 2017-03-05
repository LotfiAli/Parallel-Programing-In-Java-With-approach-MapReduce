package IO.core.parser.metaDataParser;

import IO.core.exception.BaseExcelParserException;
import IO.core.parser.MetaDataObject;
import IO.core.parser.TypeObject;
import IO.core.reflection.Utility;

import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * Created by alotfi on 6/5/2016.
 */
//TODO must be to class
public class ComplexTypeParser extends BaseComplexParser {

    @Override
    public void ParserElement(MetaDataObject metaDataObject, Field field, Object targetObject) throws BaseExcelParserException {
        Class<?> type = field.getType();
        ;
//        Field[] fieldComplexObject = type.getDeclaredFields();

        MetaDataObject metaDataObjectComposite = parseElement(field);
        metaDataObjectComposite.setComplex(true);
        metaDataObjectComposite.setTypeGeneric(field.getType());
        metaDataObjectComposite.setArray(false);
        metaDataObjectComposite.setField(field);
        metaDataObjectComposite.setType(type);
        if (metaDataObjectComposite.getSheetName() == null)
            metaDataObjectComposite.setSheetName(field.getName());

        metaDataObject.getMetaDataObjects().add(metaDataObjectComposite);
        metaDataObjectComposite.getMetaDataObjects().add(metaDataObjectComposite);
        metaDataObject.setTypeObject(TypeObject.COMPLEX);
        metaDataObjectComposite.setTypeObject(TypeObject.COMPLEX);
        parseComplexObject(type, metaDataObjectComposite, targetObject, field);

    }

    @Override
    protected ArrayList<Object> getValueObject(Object targetObject, Field parentFiled) throws BaseExcelParserException {

        Object listObject = Utility.getObjectFromField(parentFiled, targetObject);
        try {
            ArrayList<Object> objectArray = new ArrayList<Object>();
            objectArray.add(listObject);
            return objectArray;
        } catch (Exception e) {
            throw new BaseExcelParserException("error new Complex object", null);
        }

    }
}
