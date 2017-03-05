package core.jobs.mapReduceJob;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alotfi on 3/1/2017.
 */
public class ContextImpl<T> implements Context<T> {
    private List<T> repository=new ArrayList<T>();

    public void Write(T item)
    {
        repository.add(item);
    }

    public List<T> getRepository() {
        return repository;
    }


}
