package core.jobs.mapReduceJob;

import java.util.List;

/**
 * Created by alotfi on 3/1/2017.
 */
public interface Context<T> {
    void Write(T item);

    List<T> getRepository();

}
