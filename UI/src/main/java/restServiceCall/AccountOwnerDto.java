package restServiceCall;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Created by alotfi on 3/4/2017.
 */
public class AccountOwnerDto {
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastName")
    private String lastName;
}
