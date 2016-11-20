package com.newthread.util;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.newthread.model.Message;
import com.newthread.model.Response;


public class MessageMaker {

    private static ObjectMapper mapper = new ObjectMapper();

    private MessageMaker() {
    }

    public static Message make(String code, String content, String mark) {
        return new Message(code, content, mark);
    }

    public static String makeJson(String code, String content, String mark) {
        return "{'name':'dd'}";
    }

    public static Response make(int x) {
        return new Response(x);
    }


    public static Object makeFspid(String fspid) {
        return "{\"fspid:\"" + fspid + "}";
    }

    public static String makeFid(String fid) {
        return "{\"fid\":" + fid + "}";
    }
}
