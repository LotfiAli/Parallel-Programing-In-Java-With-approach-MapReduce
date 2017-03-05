package core.ResourceManager.JobResource;

import core.ResourceManager.JobResource.impl.TaskResource;
import core.jobs.InputExecuteJob;
import core.jobs.Jobs;
import core.jobs.mapReduceJob.ContextImpl;
import core.jobs.mapReduceJob.ReduceJob;
import utility.PcManager;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by alotfi on 3/3/2017.
 */
public class ManageTasks {
    private List<TaskRunner> tasks = new ArrayList<TaskRunner>();
    private Integer rowIndex = 0;
    private Jobs job;
    private ThreadPoolExecutor executor;

    public ManageTasks(Jobs job) throws Exception {
        this.job = job;
    }

    public int startTask() throws Exception {
        prepareTasks();
        return startTasks();
    }

    private Collection getAllTaskExcutor() throws Exception {
        Collection collection = new ArrayList();
        for (TaskRunner item : tasks)
            collection.add(item);
        return collection;
    }

    private int startTasks() throws Exception {
        this.executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(PcManager.getCountCpu());

        List<Future<Object>> result = executor.invokeAll(getAllTaskExcutor());
        this.executor.shutdown();
        this.executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        List<Object> resultTask = joinResult();
        ReduceJob reduceJob = job.getReduceJob();
        ContextImpl contextReduce = new ContextImpl();
        reduceJob.reduce(resultTask, contextReduce);
        job.getOutputExecuteJob().submit(contextReduce.getRepository());
        return 1;
    }

    private List<Object> joinResult() throws Exception {

        List<Object> collectResult = new ArrayList<Object>();
        for (int i = 0; i <= tasks.size() - 1; i++) {
            collectResult.add(tasks.get(i).getContext());
        }
        return collectResult;
    }


    private List getItemsForTask(List resultList, int toIndex) {
        return resultList.subList(rowIndex, rowIndex += toIndex);
        //TODO Must Calculate Lenght List


    }

    private void prepareTasks() throws Exception {
        InputExecuteJob inputExecuteJob = job.getInputExecuteJob();
        List resultList = inputExecuteJob.submit();
        int countCore = PcManager.getCountCpu();
        int toIndex = resultList.size() / countCore;
        for (int i = 1; i <= countCore; i++) {
            TaskRunner task = new TaskResource(i, getItemsForTask(resultList,toIndex), new ContextImpl());
            task.setMapJob(job.getMapJob());
            tasks.add(task);
        }
    }

    public void setTaskRunner(TaskRunner taskRunner) {
        tasks.add(taskRunner);
    }

    public List<TaskRunner> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskRunner> tasks) {
        this.tasks = tasks;
    }
}
