package defaultImpl.mapReduce;


import core.jobs.mapReduceJob.Context;
import core.jobs.mapReduceJob.ContextImpl;
import core.jobs.mapReduceJob.ReduceJob;
import restServiceCall.ShebaDto;
import test.Body;
import test.MessageExcel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alotfi on 3/1/2017.
 */
public class RestServiceCallReduce implements ReduceJob<Object, Object> {
    public void reduce(Object input, Context context) {
        List<ContextImpl> result = (List<ContextImpl>) input;
        List<ShebaDto> flatResult = new ArrayList<ShebaDto>();
        for (ContextImpl item : result) {
            flatResult.addAll((List<ShebaDto>)item.getRepository());
        }
        context.Write(flatResult);
    }

    public Context getContext() {
        return null;
    }
}
