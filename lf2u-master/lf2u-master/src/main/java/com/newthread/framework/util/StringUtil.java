package com.newthread.framework.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.security.MessageDigest;
import java.util.Date;
import java.util.Random;


public class StringUtil {

    private static char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
    private static String[] images = {"image/png","image/jpg","image/webp","image/*"};
    private static ObjectMapper mapper;
    private static Random random = new Random();

    static {
        mapper = new ObjectMapper();
    }

    /**
     *
     * @param obj
     * @return
     */
    public static String obj2json(Object obj){

        String str = null;

        try {
            str = mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return str;
    }

    private StringUtil(){};
    /**
     *
     * @param s
     * @return
     */
    public final static String getMD5(String s) {

        try {
            byte[] btInput = s.getBytes();
            //get objects from MessageDigest
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
           
            mdInst.update(btInput);
            // get security message
            byte[] md = mdInst.digest();
            // translate message to char in hexadecimal
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean isNumber(String str){

        if(isEmpty(str)){
            return false;
        }

        for (int i = str.length();--i>=0;){
            if (!Character.isDigit(str.charAt(i))){
                return false;
            }
        }
        return true;
    }

    public static boolean isEmpty(String code){
        if(null == code || code.equals("") || code.matches("\\s*")){
            return true;
        }
        return false;
    }

    public static Integer randomInteger(){
        return random.nextInt(1000);
    }


    public static boolean randomBoolean(){
        return random.nextBoolean();
    }
}
