package core.jobs;

import java.util.List;

/**
 * Created by alotfi on 2/28/2017.
 */
public interface InputExecuteJob<T> {
    List<T>  submit() throws Exception;
}
