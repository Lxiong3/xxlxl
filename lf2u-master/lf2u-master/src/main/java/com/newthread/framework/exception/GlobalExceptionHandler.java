package com.newthread.framework.exception;

import com.newthread.framework.util.MessageMaker;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;


public class GlobalExceptionHandler implements HandlerExceptionResolver {

    @ResponseBody
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        response.setContentType("application/json;charset=utf-8");
        ex.printStackTrace();

        if (ex instanceof NumberFormatException || ex instanceof ArgumentsException) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            printWrite(MessageMaker.makeJson(null, "please enter the correct value ！", null), response);
        } else if (ex instanceof _404Exception) {
            response.setStatus(HttpStatus.NOT_FOUND.value());
            printWrite(MessageMaker.makeJson(null, "no such resource！", null), response);
        } else if (ex instanceof NoHandlerFoundException) {
            response.setStatus(HttpStatus.NOT_FOUND.value());
            printWrite(MessageMaker.makeJson(null, "no such resource！", null), response);
        } else {
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            printWrite(MessageMaker.makeJson(null, "unknown error ？", null), response);
        }
        return null;
    }

    public void printWrite(String msg, HttpServletResponse response) {
        try {
            PrintWriter pw = response.getWriter();
            pw.write(msg);
            pw.flush();
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
