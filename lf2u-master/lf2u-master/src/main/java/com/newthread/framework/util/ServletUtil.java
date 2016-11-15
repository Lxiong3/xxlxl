package com.newthread.framework.util;

import javax.servlet.http.HttpServlet;


public class ServletUtil {

    private ServletUtil(){};

    /**
     * 
     * @param servlet
     * @param name
     * @return
     */
    public static String getInitParameter(HttpServlet servlet,String name){
        return servlet.getServletConfig().getInitParameter(name);
    }


}
