package vn.cmctelecom.scheduler.enitiy.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.cmctelecom.scheduler.util.Result;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseData<T> {
    private int code;
    private String message;
    private T Data;

    public ResponseData(Result result) {
        this.code = result.getCode();
        this.message = result.getMessage();
    }

    public ResponseData(T data, Result result) {
        this.Data = data;
        this.code = result.getCode();
        this.message = result.getMessage();
    }

    @JsonIgnore
    public boolean isSucess() {
        return (this.code == 1);
    }
}
