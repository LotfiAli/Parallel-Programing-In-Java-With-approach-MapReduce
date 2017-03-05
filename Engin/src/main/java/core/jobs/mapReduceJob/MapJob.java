package core.jobs.mapReduceJob;

/**
 * Created by alotfi on 3/1/2017.
 */
public interface MapJob<T, O> {
    void map(T input, Context context) throws Exception;
}
