package core.ResourceManager.queue.impl;

import core.ResourceManager.JobResource.ApplicationManager;
import core.ResourceManager.JobResource.impl.ApplicationManagers;
import core.jobs.Jobs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by alotfi on 2/28/2017.
 */
public class ResourceManagers implements core.ResourceManager.ResourceManagers {

    private Map<String, ApplicationManagers> jobs = new HashMap<String, ApplicationManagers>();
    private ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
    private static ResourceManagers resourceManagers;

    private ResourceManagers() {
    }

    public static ResourceManagers getResourceManager() {
        if (resourceManagers == null)
            resourceManagers = new ResourceManagers();
        return resourceManagers;

    }

    public String sendJobs(Jobs job) throws Exception {

        //Check Thread Pool For empty Job
        String code = java.util.UUID.randomUUID().toString();
        jobs.put(code, new ApplicationManagers(job));
        return code;
    }

    public int submit(String id) throws Exception {
        if (jobs.containsKey(id)) {
            ApplicationManagers job = jobs.get(id);
            job.call();
            return 1;
        }
        throw new Exception("No Job Find");
    }

    public void killAllJob() {
    }
}
