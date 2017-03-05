package core.jobs;

import java.util.List;

/**
 * Created by alotfi on 2/28/2017.
 */
public interface OutPutExecuteJob<T> {
    void submit(T items) throws Exception;
}
