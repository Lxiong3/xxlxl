package com.newthread.framework.db;

import com.newthread.framework.entity.Products;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class ProductDB {

    public static Map<String, Products> map = new HashMap<>();

    static {

        Products p1 = new Products("1", "Apple", "very nice apple ", "2016-1-9", "2016-5-1", 5.0, "", "");
        Products p2 = new Products("2", "Lemon ", "very nice Lemon  ", "2016-1-3", "2016-4-1", 6.0, "", "");
        Products p3 = new Products("345", "Grape ", "very nice Grape  ", "2016-2-3", "2016-6-1", 8.0, "", "");
        Products p4 = new Products("345", "guava", "very nice guava ", "2016-11-3", "2016-12-1", 7.0, "", "");
        Products p5 = new Products("5", "plum ", "very nice plum  ", "2016-3-3", "2016-8-1", 11.0, "", "");

        map.put(p1.getFspid(), p1);
        map.put(p2.getFspid(), p2);
        map.put(p3.getFspid(), p3);
        map.put(p4.getFspid(), p4);
        map.put(p5.getFspid(), p5);


    }


    private static Random r = new Random();

    public static Products randomGet() {

        for (Map.Entry<String, Products> entry : map.entrySet()) {
            if(r.nextBoolean()){
                if (r.nextBoolean()) {
                    return entry.getValue();
                }
            }
        }
        return null;
    }
}
