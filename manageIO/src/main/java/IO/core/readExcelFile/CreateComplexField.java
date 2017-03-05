package IO.core.readExcelFile;


import IO.core.base.templateComponent.wrapperFile.WrapperBody;
import IO.core.base.templateComponent.wrapperFile.WrapperFileImpl;
import IO.core.base.templateComponent.wrapperFile.WrapperRow;
import IO.core.enumParser.StateValidationItem;
import IO.core.parser.MetaDataObject;
import IO.core.reflection.Utility;
import IO.core.validation.ValidationResult;
import IO.core.validation.ValidationResultItem;

import java.lang.reflect.Field;

/**
 * Created by alotfi on 5/28/2016.
 */
public class CreateComplexField extends CreateObjectFromMetaData {


    public CreateComplexField(Object instance, WrapperFileImpl wrapperExcel, ValidationResult validationResult) {
        super(instance, wrapperExcel, validationResult);
    }

    @Override
    protected void writeField(MetaDataObject metaDataObject, Object obj) {

    }

    @Override
    protected void readField(WrapperBody body, MetaDataObject metaDate) {
        WrapperRow bodyRow = body.getRowBodyByIndex(0);
        Field objectField = metaDate.getField();
        objectField.setAccessible(true);
        Object selectObject = null;
        try {
            selectObject = Utility.getObjectFromField(objectField, getInstance());
            createRowFromMeatData(selectObject, bodyRow, metaDate);
        } catch (Exception e) {
//            validationResult.addItem(new ValidationResultItem(StateValidationItem.READ_FIELD_ERROR, metaDate.getDescriptionColumn(), bodyRow.getRowNumber()));
            validationResult.addItem(new ValidationResultItem(StateValidationItem.READ_FIELD_ERROR.getTextError(), metaDate.getDescriptionColumn(), bodyRow.getRowNumber()));
        }

    }


}
