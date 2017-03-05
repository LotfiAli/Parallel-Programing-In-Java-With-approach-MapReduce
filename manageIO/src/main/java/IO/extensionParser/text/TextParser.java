package IO.extensionParser.text;

import IO.core.base.templateComponent.wrapperFile.WrapperSheet;
import IO.core.exception.BaseExcelParserException;
import IO.core.exception.IOExcelException;
import IO.core.parser.MetaDataObject;
import IO.core.parserWrapper.ParserFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alotfi on 6/5/2016.
 */
public class TextParser implements ParserFile {

    private List<WrapperSheet> wrapperSheets = new ArrayList<WrapperSheet>();
    private String fileName;

    public TextParser(String fileName) {
        this.fileName = fileName;
    }

    public List<WrapperSheet> parse(MetaDataObject metaDataObject) throws BaseExcelParserException {
        BufferedReader contentFile = readFile(fileName);
        wrapperSheets.add(new WrapperSheet(new TextParserSheet(contentFile)));
        return wrapperSheets;
    }

    public void create(MetaDataObject metaDataObject) throws BaseExcelParserException {
        StringBuilder contentFile = new StringBuilder();
        for (MetaDataObject metaData : metaDataObject.getMetaDataObjects()) {
            TextParserSheet parserSheet = new TextParserSheet(contentFile, metaData);
            parserSheet.create();
        }
        createFile(contentFile.toString());

    }

    private void createFile(String content) throws IOExcelException {
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            File file = new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
            }

            fw = new FileWriter(file.getAbsoluteFile());
            bw = new BufferedWriter(fw);
            bw.write(content);
            bw.close();
        } catch (IOException e) {
            throw new IOExcelException("Error In Write File " + fileName, e);
        }
    }

    private BufferedReader readFile(String pathFile) throws BaseExcelParserException {
        FileInputStream fis = null;
        try {
            return new BufferedReader(new FileReader(fileName));

        } catch (Exception e) {
            throw new IOExcelException("error in read file excel from path" + pathFile, e);
        }
    }

}
