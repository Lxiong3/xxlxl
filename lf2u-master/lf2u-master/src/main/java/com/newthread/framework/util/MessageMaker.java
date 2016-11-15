package com.newthread.framework.util;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.newthread.framework.model.Message;
import com.newthread.framework.model.Response;


public class MessageMaker {

    private static ObjectMapper mapper = new ObjectMapper();

    private MessageMaker() {
    }

    public static Message make(String code, String content, String mark) {
        return new Message(code, content, mark);
    }

    public static String makeJson(String code, String content, String mark) {
        return StringUtil.obj2json(new Message(code, content, mark));
    }

    public static Response make(int x) {
        return new Response(x);
    }

    public static Object makeFspid(String fspid) {
        return "{\"fspid:\"" + fspid +"}";
    }
}
