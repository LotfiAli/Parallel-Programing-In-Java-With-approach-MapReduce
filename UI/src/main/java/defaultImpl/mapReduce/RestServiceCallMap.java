package defaultImpl.mapReduce;


import core.jobs.mapReduceJob.Context;
import core.jobs.mapReduceJob.MapJob;
import org.codehaus.jackson.map.ObjectMapper;
import restServiceCall.ExcelReadDto;
import restServiceCall.ShebaDto;

import javax.xml.bind.JAXBContext;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

/**
 * Created by alotfi on 3/1/2017.
 */
public class RestServiceCallMap implements MapJob<Object, Object> {
    public void map(Object input, Context context) throws Exception {
        System.out.print(Thread.currentThread().getName());
        if (input != null) {
            ExcelReadDto shebaNumber = (ExcelReadDto) input;
            context.Write(callRestService(shebaNumber.getSheba()));
        }
    }

    private ShebaDto callRestService(String sheba) throws Exception {
        try {
            URL url = new URL("https://sheba.bmi.ir/sheba/rest/api/IBAN/getIbanDetails?iban=" + sheba + "&token=IGD123654");
            System.out.println(sheba);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;
            StringBuilder sb = new StringBuilder();
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                sb.append(output);
            }
            ObjectMapper objectMapper = new ObjectMapper();
            ShebaDto sample = objectMapper.readValue(sb.toString(), ShebaDto.class);
            conn.disconnect();
            return sample;
        } catch (Exception e) {
            ShebaDto d = new ShebaDto();
//            d.setException(e.getMessage());
            return d;

        }
    }
}
