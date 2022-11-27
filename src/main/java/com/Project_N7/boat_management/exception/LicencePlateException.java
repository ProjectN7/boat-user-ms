package com.Project_N7.boat_management.exception;
import com.Project_N7.boat_management.rto.ErrorRTO;
import org.springframework.http.HttpStatus;

import java.util.List;

public class LicencePlateException extends Exception {


    private static final long serialVersionUID = 1L;

    private HttpStatus http_status;

    private List<ErrorRTO> errorRTO_list;

    public LicencePlateException() { super(); }

    public LicencePlateException(List<ErrorRTO> errorRTO_list, HttpStatus http_status) {
        super();
        this.errorRTO_list = errorRTO_list;
        this.http_status = http_status;
    }

    public LicencePlateException(String message) {
        super(message);
    }

    public LicencePlateException(String message, HttpStatus http_status) {
        super(message);
        this.http_status = http_status;
    }

    public HttpStatus getHttp_status() {
        return http_status;
    }

    public void setHttp_status(HttpStatus http_status) {
        this.http_status = http_status;
    }

    public List<ErrorRTO> getErrorRTO_list() {
        return errorRTO_list;
    }

    public void setErrorRTO_list(List<ErrorRTO> errorRTO_list) {
        this.errorRTO_list = errorRTO_list;
    }
}