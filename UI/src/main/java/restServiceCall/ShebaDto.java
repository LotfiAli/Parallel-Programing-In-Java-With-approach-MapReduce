package restServiceCall;

import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

/**
 * Created by alotfi on 3/4/2017.
 */
public class ShebaDto {

    @JsonProperty("requestedIban")
    private String requestedIban;
    @JsonProperty("accountNumber")
    private String accountNumber;
    @JsonProperty("accountStatus")
    private String accountStatus;
    @JsonProperty("paymentCode")
    private String paymentCode;
    @JsonProperty("paymentCodeValid")
    private String paymentCodeValid;
    @JsonProperty("accountComment")
    private String accountComment;
    @JsonProperty("errorCode")
    private String errorCode;
    @JsonProperty("accountOwner")
    private List<AccountOwnerDto> accountOwnerDto;
    @JsonProperty("referenceNumber")
    private String referenceNumber;





    public ShebaDto() {
//        accountOwnerDto =new ArrayList<AccountOwnerDto>();
    }

    public String getRequestedIban() {
        return requestedIban;
    }

    public void setRequestedIban(String requestedIban) {
        this.requestedIban = requestedIban;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public String getPaymentCode() {
        return paymentCode;
    }

    public void setPaymentCode(String paymentCode) {
        this.paymentCode = paymentCode;
    }

    public String getPaymentCodeValid() {
        return paymentCodeValid;
    }

    public void setPaymentCodeValid(String paymentCodeValid) {
        this.paymentCodeValid = paymentCodeValid;
    }

    public String getAccountComment() {
        return accountComment;
    }

    public void setAccountComment(String accountComment) {
        this.accountComment = accountComment;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public List<AccountOwnerDto> getAccountOwnerDto() {
        return accountOwnerDto;
    }
//
    public void setAccountOwnerDto(List<AccountOwnerDto> accountOwnerDto) {
        this.accountOwnerDto = accountOwnerDto;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }


    @Override
    public String toString() {
        return "ShebaDto{" +
                "requestedIban='" + requestedIban + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", accountStatus='" + accountStatus + '\'' +
                ", paymentCode='" + paymentCode + '\'' +
                ", paymentCodeValid='" + paymentCodeValid + '\'' +
                ", accountComment='" + accountComment + '\'' +
                ", errorCode='" + errorCode + '\'' +
                ", accountOwnerDto=" + accountOwnerDto +
                ", referenceNumber='" + referenceNumber + '\'' +
                '}';
    }
}
