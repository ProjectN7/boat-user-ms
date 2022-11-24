package com.Project_N7.boat_management.exception;

import com.Project_N7.boat_management.rto.errorRTO;
import org.springframework.http.HttpStatus;

import java.util.List;

public class cf_exception extends Exception{

    private static final long serialVersionUID = 1L;

    private HttpStatus http_status;

    private List<errorRTO> errorRTO_list;

    public cf_exception()  { super(); }

    public cf_exception(List<errorRTO> errorRTO_list, HttpStatus http_status) {
        super();
        this.errorRTO_list = errorRTO_list;
        this.http_status = http_status;
    }

    public cf_exception(String message) {
        super(message);
    }

    public cf_exception(String message, HttpStatus http_status) {
        super(message);
        this.http_status = http_status;
    }

    public HttpStatus getHttp_status() {
        return http_status;
    }

    public void setHttp_status(HttpStatus http_status) {
        this.http_status = http_status;
    }

    public List<errorRTO> getErrorRTO_list() {
        return errorRTO_list;
    }

    public void setErrorRTO_list(List<errorRTO> errorRTO_list) {
        this.errorRTO_list = errorRTO_list;
    }

}
