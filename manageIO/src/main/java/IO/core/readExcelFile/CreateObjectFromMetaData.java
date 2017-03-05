package IO.core.readExcelFile;


import IO.core.base.templateComponent.converter.Converter;
import IO.core.base.templateComponent.validation.ExecuteValidation;
import IO.core.base.templateComponent.wrapperFile.*;
import IO.core.exception.*;
import IO.core.parser.MetaDataObject;
import IO.core.reflection.Utility;
import IO.core.validation.ValidationResult;
import IO.core.validation.ValidationResultItem;

import java.lang.reflect.Field;
import java.util.List;

/**
 * Created by alotfi on 5/28/2016.
 */
public abstract class CreateObjectFromMetaData {

    public static final int NO_VALIDATION = 0;
    private WrapperFileImpl wrapperExcel;
    private WrapperSheet sheet;
    private WrapperBody rows;
    private Object instance;
    protected ValidationResult validationResult;
    private boolean isError = false;


    public CreateObjectFromMetaData(Object instance, WrapperFileImpl wrapperFile, ValidationResult validationResult) {
        this.wrapperExcel = wrapperFile;
        this.instance = instance;
        this.validationResult = validationResult;
    }

    public static CreateObjectFromMetaData createReaderField(Object instance, MetaDataObject metaData, WrapperFileImpl wrapperExcel, ValidationResult validationResult) throws BaseExcelParserException {
        if (metaData.getComplex() && metaData.getArray())
            return new CreateComplexListField(instance, wrapperExcel, validationResult);
        if (metaData.getComplex() && !metaData.getArray())
            return new CreateComplexField(instance, wrapperExcel, validationResult);
        throw new IOExcelException("can not parse this filed" + metaData.getName(), new IllegalArgumentException());
    }

    protected abstract void writeField(MetaDataObject metaDataObject, Object obj) throws BaseExcelParserException;

    protected abstract void readField(WrapperBody body, MetaDataObject metaDate) throws BaseExcelParserException;

    public void read(MetaDataObject metaDate) throws BaseExcelParserException {
        sheet = getSheet(metaDate);
        rows = sheet.getBodyRows();
        if (rows == null)
            return;
        readField(rows, metaDate);
    }

    private WrapperSheet getSheet(MetaDataObject metaDate) throws ParserException {
        return wrapperExcel.getSheetByName(metaDate.getSheetName());
    }

    protected void createRowFromMeatData(Object targetObject, WrapperRow row, MetaDataObject metaDate) {
        int i = 0;
        int rowNumber = 0;
        isError = false;
        StringBuilder tempError = new StringBuilder();
//        tempError.append(System.getProperty("line.separator"));
        for (MetaDataObject meta : metaDate.getMetaDataObjects()) {
            try {
                Field filed = Utility.getFieldByName(targetObject, meta.getName());
                WrapperCell cellOfRowById = row.getCellOfRowById(i);
                rowNumber = row.getRowNumber();
                Object value = getCellValue(cellOfRowById);
                checkValidation(value, meta, row, tempError);
                Object value1 = checkConverter(value, meta, row, tempError);
                if (value1 != null)
                    Utility.setFieldValue(filed, targetObject, value1);
                i++;

            } catch (Exception e) {
//                tempError.append(" مشکل در خوانایی فایل " + meta.getDescriptionColumn() + " " + rowNumber + " " + row.getRowData()+".");
            }
        }
        if (isError) {
//            String errorMessage = new StringBuilder().append(row.getRowNumber()).append("\u202B").append(row.getRowData()).append("\u202C").append(tempError.toString()).append(System.getProperty("line.separator")).toString();
//            String errorMessage = row.getRowNumber() + ": " + row.getRowData() + " " + tempError.toString() + System.getProperty("line.separator");
//            String errorMessage =""+ row.getRowNumber() + ": "  + tempError.toString() + System.getProperty("line.separator");
            validationResult.addItem(new ValidationResultItem(row.getRowNumber(),tempError.toString()));
        }

    }

    private Object getCellValue(WrapperCell cellOfRowById) {
        return cellOfRowById.getCellValue();
    }

    private Object checkConverter(Object value, MetaDataObject meta, WrapperRow row, StringBuilder errorMessage) throws ConverterParserException {
        if(value==null || "".equals(value.toString()))
            return null;
        Converter converter = meta.getConverters();
        if (converter == null)
            return value;
        try {
            return converter.convertTo(value);
        } catch (Exception e) {
            isError = true;
            errorMessage.append("خطا در تبدیل فیلد " + meta.getDescriptionColumn()+".");
        }
        return null;
    }

    private void checkValidation(Object value, MetaDataObject meta, WrapperRow row, StringBuilder errorMessage) throws ValidationParserException {
        List<ExecuteValidation> aBooleen = meta.getValidations();
        if (aBooleen.size() == NO_VALIDATION)
            return;
        for (ExecuteValidation aBoolean : aBooleen) {
            String valid = aBoolean.isValid(value,meta.getDescriptionColumn() );
            if (valid != null && !"".equals(valid)) {
                isError = true;
                errorMessage.append(valid);
                errorMessage.append(" ");
//                errorMessage.append( meta.getDescriptionColumn());
//                errorMessage.append(" ");
                errorMessage.append(".");
            }
        }
    }

    public Object getInstance() {
        return instance;
    }
}


