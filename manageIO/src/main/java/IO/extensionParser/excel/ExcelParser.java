package IO.extensionParser.excel;

import IO.core.base.templateComponent.wrapperFile.WrapperSheet;
import IO.core.exception.BaseExcelParserException;
import IO.core.exception.IOExcelException;
import IO.core.io.ExportFile;
import IO.core.parser.MetaDataObject;
import IO.core.parserWrapper.ParserFile;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alotfi on 6/5/2016.
 */
public class ExcelParser implements ParserFile {

    private List<WrapperSheet> wrapperSheets = new ArrayList<WrapperSheet>();
    private String fileName;
    private ExportFile exportFile;

    public ExcelParser(String fileName) {
        this.fileName = fileName;
    }

    public ExcelParser(String fileName, ExportFile exportFile) {
        this.fileName = fileName;
        this.exportFile = exportFile;

    }

    public List<WrapperSheet> parse(MetaDataObject metaDataObject) throws BaseExcelParserException {
        XSSFWorkbook xssfSheets = readFile(fileName);
        for (int i = 0; i < xssfSheets.getNumberOfSheets(); i++) {
            XSSFSheet sheet = xssfSheets.getSheetAt(i);
            wrapperSheets.add(new WrapperSheet(new ExcelParserSheet(sheet)));
        }
        return wrapperSheets;
    }

    public void create(MetaDataObject metaDataObject) throws BaseExcelParserException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        for (MetaDataObject metaData : metaDataObject.getMetaDataObjects()) {
            ExcelParserSheet parserSheet = new ExcelParserSheet(workbook, metaData);
            parserSheet.create();
//            wrapperSheets.add(new WrapperSheet(parserSheet));
        }
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(new File(fileName));
            workbook.write(out);
        } catch (FileNotFoundException e) {
            throw new IOExcelException("error create Excel File", e);
        } catch (IOException e) {
            throw new IOExcelException("error create Excel File", e);
        }

    }

    private XSSFWorkbook readFile(String pathFile) throws BaseExcelParserException {
        FileInputStream fis = null;
        try {

            fis = new FileInputStream(new File(pathFile));
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            return workbook;

        } catch (Exception e) {
            throw new IOExcelException("error in read file excel from path" + pathFile, e);
        }
    }

}
