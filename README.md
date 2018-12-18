## # ### ## #  Parallel Programing In JavaEasy with With approach MapReduce


Ali Lotfi edited this page an hour ago · 1 revision
Welcome to the ParallelProgramingInJavaEasy- wiki!

Hello. I had a duty to do. I had to call a service with different data many times. It was here that each of these calls was separate from each other. Thus, by inspiration from the Hadoop and the MapReduce algorithm, each CPU core As a node, we have a map file that runs on any CPU core, and so each map will eventually be merged with a Reduce.

## # ### ## # create map class
public class RestServiceCallMap implements MapJob<Object, Object> {

`public void map(Object input, Context context) throws Exception {`

    `System.out.print(Thread.currentThread().getName());`

    `if (input != null) {`

        `ExcelReadDto shebaNumber = (ExcelReadDto) input;`

        `context.Write(callRestService(shebaNumber.getSheba()));`
}
}
 

 private ShebaDto callRestService(String sheba) throws Exception {
  
 }
          
          

### ## # create reduce class


public class RestServiceCallReduce implements ReduceJob<Object, Object> {

public void reduce(Object input, Context context) {

    List<ContextImpl> result = (List<ContextImpl>) input;

    List<ShebaDto> flatResult = new ArrayList<ShebaDto>();

    for (ContextImpl item : result) {

        flatResult.addAll((List<ShebaDto>)item.getRepository());

    }

    context.Write(flatResult);

}


} 


### ## # You can specify the input of the map algorithm

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

### ## # You can specify the input of the reduce algorithm

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

## ### ****YOU must create a job class to execute your map/Reduce code
public class RunRestServiceJob implements RunAbleJob {

private Jobs job;


public void run(Object[] args) throws Exception {

    ConfigurationSystem config = new ConfigurationSystem();

    job = new Jobs();

    job.setConfiguration(config);
// job.submit(null);

    job.setMapJob(new RestServiceCallMap());

    job.setReduceJob(new RestServiceCallReduce());

    ManageInputJobsFile.addInputPath(job, "d:\\sheeba.xlsx");

    ManageOutputJobsFile.addOutputPath(job, "d:\\Book1201.xlsx");

    job.waitForCompletion();

}


public core.jobs.Jobs getJobs() {

    return job;

}
}
