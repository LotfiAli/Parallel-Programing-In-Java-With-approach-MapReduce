package test;

import IO.core.base.ExcelManagerFactory;
import IO.core.base.ParserManager;
import IO.core.model.ResultModel;
import defaultImpl.RunRestServiceJob;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alotfi on 5/24/2016.
 */
public class Launcher {
    public static void main(String[] args) throws Exception {
//        ExcelCall();
//        callFile();
        testCallRestService();

    }

    private static void callFile() throws Exception {
//        ParserManager excelManager = ExcelManagerFactory.getParserManager(MessageFile.class,new TextParser("d:\\book2.txt"));
//        ResultModel message = excelManager.deSerialize();
//        System.out.println(message.getResultModel().toString());
//
//        ParserManager excelManager1 = ExcelManagerFactory.getParserManager(MessageFile.class,new TextParser("d:\\book3.txt"));
//        excelManager1.serialize(message.getResultModel());
//
//        System.out.println(message.getResultModel().toString());
    }

    private static void ExcelCall() throws Exception {
//        ParserManager excelManager = ExcelManagerFactory.getExcelParserManager("d:\\Book1.xlsx", MessageExcel.class);
//        ResultModel message = excelManager.deSerialize();
//        System.out.println(message.getResultModel().toString());
        MessageExcel messageExcel = new MessageExcel();
//        messageExcel.setTitel("hiii");
//        messageExcel.setDescription("reza");
//        messageExcel.setFamily("ali");
//        messageExcel.setName("tt");
        List<Body> message = new ArrayList<Body>();
        message.add(new Body("Ali", "lotfi", "1000000"));
        message.add(new Body("Ali1", "lotfi1", "1000001"));
        message.add(new Body("Ali2", "lotfi2", "10002"));
        message.add(new Body("Ali3", "lotfi3", "10003"));
        message.add(new Body("Ali4", "lotfi4", "10004"));
        messageExcel.setMessage(message);
        ParserManager excelManagerSerialize = ExcelManagerFactory.getExcelParserManager("d:\\Book2.xlsx", MessageExcel.class);
        excelManagerSerialize.serialize(messageExcel);
    }

    private static void testCallRestService() throws Exception {
        RunRestServiceJob runRestServiceJob=new RunRestServiceJob();
        runRestServiceJob.run(null);

    }


}
