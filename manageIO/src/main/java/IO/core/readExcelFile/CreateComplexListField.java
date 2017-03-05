package IO.core.readExcelFile;


import IO.core.base.templateComponent.wrapperFile.WrapperBody;
import IO.core.base.templateComponent.wrapperFile.WrapperFileImpl;
import IO.core.base.templateComponent.wrapperFile.WrapperRow;
import IO.core.enumParser.StateValidationItem;
import IO.core.exception.BaseExcelParserException;
import IO.core.parser.MetaDataObject;
import IO.core.reflection.Utility;
import IO.core.validation.ValidationResult;
import IO.core.validation.ValidationResultItem;

import java.lang.reflect.Field;

/**
 * Created by alotfi on 5/28/2016.
 */
public class CreateComplexListField extends CreateObjectFromMetaData {

    public static final String ADD = "add";

    public CreateComplexListField(Object instance, WrapperFileImpl wrapperExcel, ValidationResult validationResult) {
        super(instance, wrapperExcel, validationResult);
    }

    @Override
    protected void writeField(MetaDataObject metaDataObject, Object obj) throws BaseExcelParserException {
        Object targetObject = Utility.getObjectFromField(metaDataObject.getField(), obj);

    }

    protected void readField(WrapperBody body, MetaDataObject metaDate) {
        Object objectInstance = null;
        Field field = metaDate.getField();
        field.setAccessible(true);
        Object listObject = null;

        try {
            listObject = Utility.getObjectFromField(field, getInstance());
        } catch (BaseExcelParserException e1) {
//            validationResult.addItem(new ValidationResultItem(StateValidationItem.READ_FIELD_ERROR, metaDate.getDescriptionColumn()));
            validationResult.addItem(new ValidationResultItem(StateValidationItem.READ_FIELD_ERROR.getTextError(), metaDate.getDescriptionColumn()));
            return;
        }
        for (WrapperRow row : body.getAllRows()) {

            try {
                objectInstance = Utility.newInstanceFromType(metaDate.getType());
                createRowFromMeatData(objectInstance, row, metaDate);
                Utility.addItemToToList(listObject, objectInstance);
            } catch (Exception e) {
                validationResult.addItem(new ValidationResultItem(StateValidationItem.READ_FIELD_ERROR.getTextError(), metaDate.getDescriptionColumn(), row.getRowNumber(), row.getRowData()));
            }
        }
    }
}


