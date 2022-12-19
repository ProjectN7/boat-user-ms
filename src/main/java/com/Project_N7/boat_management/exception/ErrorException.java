package com.Project_N7.boat_management.exception;

import com.Project_N7.boat_management.rto.ErrorRTO;

import java.util.List;

public class ErrorException extends Exception{
    private static final long serialVersionUID = 1L;
    private ErrorRTO errorRTO;
    private List<ErrorRTO> errorRTOList;

    public ErrorException() { super(); }

    public ErrorException(ErrorRTO errorRTO) {
        super();
        this.errorRTO = errorRTO;
    }

    public ErrorException(List<ErrorRTO> errorRTOList) {
        super();
        this.errorRTOList = errorRTOList;
    }

    public ErrorException(String message) {
        super(message);
    }


    public ErrorRTO getErrorRTO() {
        return errorRTO;
    }

    public void setErrorRTO(ErrorRTO errorRTO) {
        this.errorRTO = errorRTO;
    }

    public List<ErrorRTO> getErrorRTOList() {
        return errorRTOList;
    }

    public void setErrorRTOList(List<ErrorRTO> errorRTOList) {
        this.errorRTOList = errorRTOList;
    }
}
