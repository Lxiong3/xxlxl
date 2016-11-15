package com.newthread.framework.db;

import com.newthread.framework.entity.Catalog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CatalogDB {

    //public static Map<String, Catalog> map = new HashMap<>();

    public static List<Catalog> list = new ArrayList<>();

/*    static {

        Catalog log = new Catalog();
        Catalog log1 = new Catalog();
        Catalog log2 = new Catalog();


        log.setGcpid("125");
        log.setName("Potatoes");

        log1.setGcpid("126");
        log1.setName("Tomatoes");

        log2.setGcpid("127");
        log2.setName("Eggplant");

        map.put(log.getGcpid(), log);
        map.put(log1.getGcpid(), log1);
        map.put(log2.getGcpid(), log2);


    }*/

    static {

        Catalog log = new Catalog();
        Catalog log1 = new Catalog();
        Catalog log2 = new Catalog();


        log.setGcpid("125");
        log.setName("Potatoes");

        log1.setGcpid("126");
        log1.setName("Tomatoes");

        log2.setGcpid("127");
        log2.setName("Eggplant");

        list.add(log);
        list.add(log1);
        list.add(log2);


    }
}




