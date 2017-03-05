package IO.core.readExcelFile;

import IO.core.base.templateComponent.wrapperFile.WrapperBody;
import IO.core.base.templateComponent.wrapperFile.WrapperFileImpl;
import IO.core.base.templateComponent.wrapperFile.WrapperRow;
import IO.core.enumParser.StateValidationItem;
import IO.core.exception.BaseExcelParserException;
import IO.core.parser.MetaDataObject;
import IO.core.validation.ValidationResult;
import IO.core.validation.ValidationResultItem;

import java.lang.reflect.Field;

/**
 * Created by alotfi on 12/4/2016.
 */
public class CreatePrimitiveField extends CreateObjectFromMetaData {

    public CreatePrimitiveField(Object instance, WrapperFileImpl wrapperFile, ValidationResult validationResult) {
        super(instance, wrapperFile, validationResult);
    }

    @Override
    protected void writeField(MetaDataObject metaDataObject, Object obj) throws BaseExcelParserException {

    }


    //This code must be refactoring
    @Override
    protected void readField(WrapperBody body, MetaDataObject metaDate) throws BaseExcelParserException {
        WrapperRow bodyRow = body.getRowBodyByIndex(0);
        Field objectField = metaDate.getField();
        objectField.setAccessible(true);
        Object selectObject = null;
        try {
           createRowFromMeatData(getInstance(), bodyRow, metaDate);
        } catch (Exception e) {
            validationResult.addItem(new ValidationResultItem(StateValidationItem.READ_FIELD_ERROR.getTextError(), metaDate.getDescriptionColumn(), bodyRow.getRowNumber()));
        }

    }
}
