package core.jobs;

import core.ConfigurationSystem;
import core.jobs.mapReduceJob.MapJob;
import core.jobs.mapReduceJob.ReduceJob;

import java.util.IllegalFormatException;
import java.util.List;

/**
 * Created by alotfi on 2/28/2017.
 */
public interface Jobs {

    <T> void setInputExecuteJob(InputExecuteJob inputExecuteJob);

    <T> void setOutputExecuteJob(OutPutExecuteJob outputExecuteJob);

//    <T> void submit(List<T> request);

    void setConfiguration(ConfigurationSystem config);

    int waitForCompletion() throws IllegalFormatException, Exception;

    void setMapJob(MapJob mapJob);

    void setReduceJob(ReduceJob reduceJob);

    InputExecuteJob getInputExecuteJob();

    OutPutExecuteJob getOutputExecuteJob();

    ConfigurationSystem getConfig();

    MapJob getMapJob();

    ReduceJob getReduceJob();




}
