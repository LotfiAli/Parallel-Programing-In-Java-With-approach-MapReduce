package core;

import core.jobs.RunAbleJob;

/**
 * Created by alotfi on 3/1/2017.
 */
public class ToolRunner {

    public static void run(RunAbleJob runAbleJob, Object[] args) throws Exception {
        runAbleJob.run(args);
    }
}
