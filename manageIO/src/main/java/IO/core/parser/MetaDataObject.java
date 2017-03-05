package IO.core.parser;

import IO.core.annotation.cell.ALIGN_CELL;
import IO.core.annotation.cell.BORDER_CELL;
import IO.core.base.templateComponent.converter.Converter;
import IO.core.base.templateComponent.validation.ExecuteValidation;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alotfi on 5/24/2016.
 */
public class MetaDataObject {

    private TypeObject typeObject;
    private List<ExecuteValidation> validations;
    private Converter converters;
    private Integer column;
    private String sheetName;
    private List<MetaDataObject> metaDataObjects;
    private Boolean isArray;
    private String name;
    private Boolean isComplex;
    private Field field;
    private Class<?> type;
    private Type typeGeneric;
    private Object valuePrimitive;
    private List<List<Object>> complexValue;
    private int blue;
    private int green;
    private int red;

    private int blueHeader;
    private int greenHeader;
    private int redHeader;

    private int countColumn;
    private String descriptionColumn;
    private Boolean titleHolder;
    private int startRowIndx;
    private int spamCell;
    private int startColumn;
    private ALIGN_CELL align_cell;
    private BORDER_CELL borderCellTop;
    private BORDER_CELL borderCellBottom;
    private BORDER_CELL borderCellLeft;
    private BORDER_CELL borderCellRight;

    private String columnTitel;


    public MetaDataObject() {
        this.metaDataObjects = new ArrayList<MetaDataObject>();
        this.blue = 250;
        this.green = 250;
        this.red = 250;

        this.blueHeader = 250;
        this.greenHeader = 250;
        this.redHeader = 250;

        this.spamCell = 1;
        this.align_cell = ALIGN_CELL.ALIGN_CENTER;

        this.borderCellTop = BORDER_CELL.BORDER_NONE;
        this.borderCellBottom = BORDER_CELL.BORDER_NONE;
        this.borderCellRight = BORDER_CELL.BORDER_NONE;
        this.borderCellLeft = BORDER_CELL.BORDER_NONE;

        this.columnTitel = "noName";

        titleHolder=false;
    }

    public TypeObject getTypeObject() {
        return typeObject;
    }

    public void setTypeObject(TypeObject typeObject) {
        this.typeObject = typeObject;
    }

    public List<ExecuteValidation> getValidations() {
        return validations;
    }

    public void setValidations(List<ExecuteValidation> validations) {
        this.validations = validations;
    }

    public Converter getConverters() {
        return converters;
    }

    public void setConverters(Converter converters) {
        this.converters = converters;
    }

    public Integer getColumn() {
        return column;
    }

    public void setColumn(Integer column) {
        this.column = column;
    }

    public String getSheetName() {
        return sheetName;
    }

    public void setSheetName(String sheetName) {
        this.sheetName = sheetName;
    }

    public List<MetaDataObject> getMetaDataObjects() {
        return metaDataObjects;
    }

    public void setMetaDataObjects(List<MetaDataObject> metaDataObjects) {
        this.metaDataObjects = metaDataObjects;
    }

    public Boolean getArray() {
        return isArray;
    }

    public void setArray(Boolean array) {
        isArray = array;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getComplex() {
        return isComplex;
    }

    public void setComplex(Boolean complex) {
        isComplex = complex;
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public Class<?> getType() {
        return type;
    }

    public void setType(Class<?> type) {
        this.type = type;
    }

    public Type getTypeGeneric() {
        return typeGeneric;
    }

    public void setTypeGeneric(Type typeGeneric) {
        this.typeGeneric = typeGeneric;
    }

    public Object getValuePrimitive() {
        return valuePrimitive;
    }

    public void setValuePrimitive(Object valuePrimitive) {
        this.valuePrimitive = valuePrimitive;
    }

    public List<List<Object>> getComplexValue() {
        return complexValue;
    }

    public void setComplexValue(List<List<Object>> complexValue) {
        this.complexValue = complexValue;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public int getCountColumn() {
        return countColumn;
    }

    public void setCountColumn(int countColumn) {
        this.countColumn = countColumn;
    }

    public String getDescriptionColumn() {
        return descriptionColumn;
    }

    public void setDescriptionColumn(String descriptionColumn) {
        this.descriptionColumn = descriptionColumn;
    }

    public Boolean getTitleHolder() {
        return titleHolder;
    }

    public void setTitleHolder(Boolean titleHolder) {
        this.titleHolder = titleHolder;
    }

    public int getStartRowIndx() {
        return startRowIndx;
    }

    public void setStartRowIndx(int startRowIndx) {
        this.startRowIndx = startRowIndx;
    }

    public int getSpamCell() {
        return spamCell;
    }

    public void setSpamCell(int spamCell) {
        this.spamCell = spamCell;
    }

    public int getStartColumn() {
        return startColumn;
    }

    public void setStartColumn(int startColumn) {
        this.startColumn = startColumn;
    }

    public ALIGN_CELL getAlign_cell() {
        return align_cell;
    }

    public void setAlign_cell(ALIGN_CELL align_cell) {
        this.align_cell = align_cell;
    }

    public int getBlueHeader() {
        return blueHeader;
    }

    public void setBlueHeader(int blueHeader) {
        this.blueHeader = blueHeader;
    }

    public int getGreenHeader() {
        return greenHeader;
    }

    public void setGreenHeader(int greenHeader) {
        this.greenHeader = greenHeader;
    }

    public int getRedHeader() {
        return redHeader;
    }

    public void setRedHeader(int redHeader) {
        this.redHeader = redHeader;
    }

    public BORDER_CELL getBorderCellTop() {
        return borderCellTop;
    }

    public void setBorderCellTop(BORDER_CELL borderCellTop) {
        this.borderCellTop = borderCellTop;
    }

    public BORDER_CELL getBorderCellBottom() {
        return borderCellBottom;
    }

    public void setBorderCellBottom(BORDER_CELL borderCellBottom) {
        this.borderCellBottom = borderCellBottom;
    }

    public BORDER_CELL getBorderCellLeft() {
        return borderCellLeft;
    }

    public void setBorderCellLeft(BORDER_CELL borderCellLeft) {
        this.borderCellLeft = borderCellLeft;
    }

    public BORDER_CELL getBorderCellRight() {
        return borderCellRight;
    }

    public void setBorderCellRight(BORDER_CELL borderCellRight) {
        this.borderCellRight = borderCellRight;
    }

    public String getColumnTitel() {
        return columnTitel;
    }

    public void setColumnTitel(String columnTitel) {
        this.columnTitel = columnTitel;
    }
}
