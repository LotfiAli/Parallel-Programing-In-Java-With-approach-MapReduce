package defaultImpl.impl;

import IO.core.base.ExcelManagerFactory;
import IO.core.base.ParserManager;
import IO.core.model.ResultModel;

import IO.extensionParser.excel.ExcelParser;
import core.jobs.InputExecuteJob;
import core.jobs.impl.Jobs;
import restServiceCall.ExcelReadDto;
import restServiceCall.ExcelReadDtosList;
import test.Body;
import test.MessageExcel;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by alotfi on 2/28/2017.
 */
public class ManageInputJobsFile {

    public static void addInputPath(final Jobs job, final String pathFile) {
        job.setInputExecuteJob(new InputExecuteJob() {

            public List submit() throws Exception {
                ParserManager excelManager = ExcelManagerFactory.getParserManager(ExcelReadDtosList.class, new ExcelParser(pathFile));
                ResultModel message = excelManager.deSerialize();
                List items = new ArrayList();
                ExcelReadDtosList messageExcel = message.getResultModel();
                for (ExcelReadDto  item : messageExcel.getMessage())
                    items.add(item);
                return items;
            }


        });
    }
}
