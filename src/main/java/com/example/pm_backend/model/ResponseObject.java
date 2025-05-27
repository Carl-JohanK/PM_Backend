package com.example.pm_backend.model;

public class ResponseObject {
    private String response;
    private int status;

    public ResponseObject(String response, int status){
        this.response = response;
        this.status = status;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
