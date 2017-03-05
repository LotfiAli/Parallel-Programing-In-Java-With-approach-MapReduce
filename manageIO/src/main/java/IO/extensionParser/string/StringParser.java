package IO.extensionParser.string;

import IO.core.base.templateComponent.wrapperFile.WrapperSheet;
import IO.core.exception.BaseExcelParserException;
import IO.core.exception.IOExcelException;
import IO.core.parser.MetaDataObject;
import IO.core.parserWrapper.ParserFile;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alotfi on 6/5/2016.
 */
public class StringParser implements ParserFile {

    public static final int ALL_CONTENT = 0;
    private List<WrapperSheet> wrapperSheets = new ArrayList<WrapperSheet>();
    private ArrayList<String> salary;

    public StringParser(ArrayList<String> data) {
        this.salary = data;
    }

    private List<String> getDataSheet(ArrayList<String> contentFile, int count) {
        if (count == ALL_CONTENT) return contentFile;
        ArrayList<String> resultList = new ArrayList<String>();
        for (int i = 0; i <= count - 1; i++) {
            resultList.add(contentFile.remove(i));
        }
        return resultList;
    }

    public List<WrapperSheet> parse(MetaDataObject metaDataObject) throws BaseExcelParserException {
        int rowIndex=0;
        for (MetaDataObject metaData : metaDataObject.getMetaDataObjects()) {
            StringParserSheet parserSheet = new StringParserSheet(getDataSheet(salary, metaData.getCountColumn()),rowIndex);
            rowIndex+=metaData.getCountColumn();
            parserSheet.setSheetName(metaData.getSheetName());
            wrapperSheets.add(new WrapperSheet(parserSheet));
        }
        return wrapperSheets;
    }

    public void create(MetaDataObject metaDataObject) throws BaseExcelParserException {
        StringBuilder contentFile = new StringBuilder();
        for (MetaDataObject metaData : metaDataObject.getMetaDataObjects()) {
            StringParserSheet parserSheet = new StringParserSheet(contentFile, metaData);
            parserSheet.create();
        }
        createFile(contentFile.toString());

    }

    private void createFile(String content) throws IOExcelException {
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            File file = new File(content);
            if (!file.exists()) {
                file.createNewFile();
            }

            fw = new FileWriter(file.getAbsoluteFile());
            bw = new BufferedWriter(fw);
            bw.write(content);
            bw.close();
        } catch (IOException e) {
            throw new IOExcelException("Error In Write File " + salary, e);
        }
    }


}
