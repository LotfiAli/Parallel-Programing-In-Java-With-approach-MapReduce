package defaultImpl.impl;


import IO.core.base.ExcelManagerFactory;
import IO.core.base.ParserManager;
import core.jobs.OutPutExecuteJob;
import core.jobs.impl.Jobs;
import core.jobs.mapReduceJob.ContextImpl;
import restServiceCall.ExcelReadDto;
import restServiceCall.ExcelReadDtosList;
import restServiceCall.ShebaDto;
import test.Body;
import test.MessageExcel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alotfi on 2/28/2017.
 */
public class ManageOutputJobsFile {

    public static void addOutputPath(Jobs job, final String pathFile) {
        job.setOutputExecuteJob(new OutPutExecuteJob() {
            public void submit(Object items) throws Exception {

                ExcelReadDtosList excelReadDtosList = new ExcelReadDtosList();
                ArrayList<ShebaDto> items1 = (ArrayList<ShebaDto>) items;
                List<ShebaDto> result = (List<ShebaDto>) items1.get(0);
                for (ShebaDto sb : result) {
                    if (sb != null)
                        excelReadDtosList.addMessage(sb.getRequestedIban(), sb.getPaymentCode(), sb.toString());
                    else
                        excelReadDtosList.addMessage("null", "error", "eeroor");
                }

                ParserManager excelManagerSerialize = ExcelManagerFactory.getExcelParserManager(pathFile, ExcelReadDtosList.class);
                excelManagerSerialize.serialize(excelReadDtosList);
            }
        });


    }
}
