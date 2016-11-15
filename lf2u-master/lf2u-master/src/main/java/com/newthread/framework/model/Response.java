package com.newthread.framework.model;


public class Response {

    int fid;

    public Response() {
    }

    public Response(int code) {
        this.fid = code;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }
}
