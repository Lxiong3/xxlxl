package com.newthread.framework.db;

import com.newthread.framework.entity.Manger;
import com.newthread.framework.util.StringUtil;

import java.util.ArrayList;
import java.util.List;


public class MangerDB {

    //public static Map<String, Catalog> map = new HashMap<>();

    public static List<Manger> list = new ArrayList<>();

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
        Manger m1 = new Manger();
        m1.setName("Tom");
        m1.setCreate_date("2015-1-1");
        m1.setCreated_by("Jack");
        m1.setEmail("2342345@qq.com");
        m1.setPhone("123123");
        m1.setMid(StringUtil.randomInteger() + "");

        Manger m2 = new Manger();
        m2.setName("Jack");
        m2.setCreate_date("2015-11-1");
        m2.setCreated_by("Admin");
        m2.setEmail("asdfasdf@qq.com");
        m2.setPhone("23666");
        m2.setMid(StringUtil.randomInteger() + "");


        Manger m3 = new Manger();
        m3.setName("Dick");
        m3.setCreate_date("2015-6-1");
        m3.setCreated_by("Jack");
        m3.setEmail("2342345@qq.com");
        m3.setPhone("2366234");
        m3.setMid(StringUtil.randomInteger() + "");

        list.add(m1);
        list.add(m2);
        list.add(m3);
    }
}




