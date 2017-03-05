package core.ResourceManager.JobResource;

import core.jobs.mapReduceJob.Context;
import core.jobs.mapReduceJob.MapJob;

import java.util.concurrent.Callable;

/**
 * Created by alotfi on 2/28/2017.
 */
public interface TaskRunner extends Callable {

    void setMapJob(MapJob mapJob);

    Context getContext();

    public int getOrder();

    public void setOrder(int order);
}
