package core.ResourceManager.JobResource.impl;

import core.ResourceManager.JobResource.TaskRunner;
import core.jobs.mapReduceJob.Context;
import core.jobs.mapReduceJob.MapJob;

import java.util.List;

/**
 * Created by alotfi on 2/28/2017.
 */
public class TaskResource implements TaskRunner {
    private int order;
    private MapJob mapJob;
    private List items;
    private Context context;

    public TaskResource(int order, List items, Context context) {
        this.order = order;
        this.items = items;
        this.context = context;
    }

    public void setMapJob(MapJob mapJob) {
        this.mapJob = mapJob;
    }

    public Context getContext() {
        return context;
    }

    public Object call() throws Exception {
//        System.out.print("I get Mapp");
        for (Object item : items)
            mapJob.map(item, context);
        return true;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}
