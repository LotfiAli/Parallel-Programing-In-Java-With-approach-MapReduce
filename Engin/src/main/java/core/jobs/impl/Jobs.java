package core.jobs.impl;

import core.ConfigurationSystem;
import core.ResourceManager.queue.impl.ResourceManagers;
import core.jobs.InputExecuteJob;
import core.jobs.OutPutExecuteJob;
import core.jobs.mapReduceJob.MapJob;
import core.jobs.mapReduceJob.ReduceJob;

import java.util.IllegalFormatException;
import java.util.List;

/**
 * Created by alotfi on 2/28/2017.
 */
public class Jobs implements core.jobs.Jobs {
    private InputExecuteJob inputExecuteJob;
    private OutPutExecuteJob outputExecuteJob;
    private ConfigurationSystem config;
    private MapJob mapJob;
    private ReduceJob reduceJob;
    private String idJob;

    public <T> void setInputExecuteJob(InputExecuteJob inputExecuteJob) {
        this.inputExecuteJob = inputExecuteJob;
    }

    public <T> void setOutputExecuteJob(OutPutExecuteJob outputExecuteJob) {
        this.outputExecuteJob = outputExecuteJob;
    }

    public void setConfiguration(ConfigurationSystem config) {
        this.config = config;
    }

    public int waitForCompletion() throws Exception {
        ResourceManagers resourceManagers = ResourceManagers.getResourceManager();

        this.idJob = resourceManagers.sendJobs(this);
        if ("".equals(idJob)) {
            throw new Exception("error error");
        }
        return resourceManagers.submit(this.idJob);
    }

    public void setMapJob(MapJob mapJob) {
        this.mapJob = mapJob;
    }

    public void setReduceJob(ReduceJob reduceJob) {
        this.reduceJob = reduceJob;
    }

    public InputExecuteJob getInputExecuteJob() {
        return inputExecuteJob;
    }

    public OutPutExecuteJob getOutputExecuteJob() {
        return outputExecuteJob;
    }

    public ConfigurationSystem getConfig() {
        return config;
    }

    public MapJob getMapJob() {
        return mapJob;
    }

    public ReduceJob getReduceJob() {
        return reduceJob;
    }
}
