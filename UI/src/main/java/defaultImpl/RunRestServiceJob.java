package defaultImpl;

import core.ConfigurationSystem;
import core.jobs.RunAbleJob;
import core.jobs.impl.Jobs;
import defaultImpl.impl.ManageInputJobsFile;
import defaultImpl.impl.ManageOutputJobsFile;
import defaultImpl.mapReduce.RestServiceCallMap;
import defaultImpl.mapReduce.RestServiceCallReduce;

/**
 * Created by alotfi on 3/1/2017.
 */
public class RunRestServiceJob implements RunAbleJob {
    private Jobs job;

    public void run(Object[] args) throws Exception {
        ConfigurationSystem config = new ConfigurationSystem();
        job = new Jobs();
        job.setConfiguration(config);
//        job.submit(null);
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
