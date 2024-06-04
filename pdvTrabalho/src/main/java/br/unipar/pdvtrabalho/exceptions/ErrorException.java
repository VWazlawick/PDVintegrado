package br.unipar.pdvtrabalho.exceptions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ErrorException {

    private List<String> errorList;

    public ErrorException(String msg) {
        this.errorList = Arrays.asList(msg);
    }

    public ErrorException(List<String> errorList){
        this.errorList = errorList;
    }

    public List<String> getErrorList() {
        return errorList;
    }

    public void setErrorList(List<String> errorList) {
        this.errorList = errorList;
    }
}
