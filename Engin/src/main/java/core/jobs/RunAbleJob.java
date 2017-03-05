package core.jobs;

/**
 * Created by alotfi on 3/1/2017.
 */
public interface RunAbleJob {

    void run(Object[] args) throws Exception;

    Jobs getJobs();
}
