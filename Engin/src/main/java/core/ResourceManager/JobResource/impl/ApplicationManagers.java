package core.ResourceManager.JobResource.impl;

import core.ResourceManager.JobResource.ApplicationManager;
import core.ResourceManager.JobResource.ManageTasks;
import core.ResourceManager.JobResource.TaskRunner;
import core.jobs.InputExecuteJob;
import core.jobs.Jobs;
import core.jobs.RunAbleJob;
import core.jobs.mapReduceJob.ContextImpl;
import utility.PcManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alotfi on 2/28/2017.
 */
public class ApplicationManagers implements core.ResourceManager.JobResource.ApplicationManager {

    private Jobs job;
    private ManageTasks manageTasks;

    public ApplicationManagers(Jobs job) throws Exception {
        this.job = job;
        this.manageTasks=new ManageTasks(job);
    }


    public Object call() throws Exception {

        return manageTasks.startTask();
    }


}
