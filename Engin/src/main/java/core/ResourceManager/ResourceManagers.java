package core.ResourceManager;

import core.jobs.Jobs;

/**
 * Created by alotfi on 2/28/2017.
 */
public interface ResourceManagers {

    String sendJobs(Jobs job) throws Exception;

    //    StateJobs getStateJobs(String id);
//
    int submit(String id) throws Exception;


}
