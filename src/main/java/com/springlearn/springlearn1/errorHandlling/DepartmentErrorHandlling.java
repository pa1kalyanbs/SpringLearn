package com.springlearn.springlearn1.errorHandlling;

public class DepartmentErrorHandlling extends Exception{
    public DepartmentErrorHandlling() {
        super();
    }

    public DepartmentErrorHandlling(String message) {
        super(message);
    }

    public DepartmentErrorHandlling(String message, Throwable cause) {
        super(message, cause);
    }

    public DepartmentErrorHandlling(Throwable cause) {
        super(cause);
    }

    protected DepartmentErrorHandlling(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
