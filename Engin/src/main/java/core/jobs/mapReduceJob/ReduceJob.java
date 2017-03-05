package core.jobs.mapReduceJob;

/**
 * Created by alotfi on 3/1/2017.
 */
public interface ReduceJob<T, O> {
    void reduce(T input, Context context);
    Context getContext();

}
