package restServiceCall;

import IO.core.annotation.column.StartColumn;
import IO.core.annotation.sheet.Sheet;
import test.Body;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alotfi on 3/4/2017.
 */
public class ExcelReadDtosList {
    @Sheet(name = "test1")
    @StartColumn(Start = 0)
    private List<ExcelReadDto> message;


    public ExcelReadDtosList() {
        message = new ArrayList<ExcelReadDto>();
    }

    public List<ExcelReadDto> getMessage() {
        return message;
    }

    public void setMessage(List<ExcelReadDto> message) {
        this.message = message;
    }
    public void addMessage(String sheba, String state, String result)
    {
        message.add(new ExcelReadDto(sheba,state,result));

    }

}
