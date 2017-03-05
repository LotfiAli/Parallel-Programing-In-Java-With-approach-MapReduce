package core.ResourceManager.queue;

import core.jobs.Jobs;

/**
 * Created by alotfi on 2/28/2017.
 */
public interface QueueJobs {

    Jobs getJobs();

    void AddJobs(Jobs job);


}
