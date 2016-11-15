package com.newthread.framework.db;

import com.newthread.framework.entity.Farm;
import com.newthread.framework.entity.Farmer;

import java.util.*;


public class FarmerDB {

    public static Map<Integer, Farmer> map = new HashMap<>();
    public static Map<Farmer, Double> delivery_charge = new HashMap<>();


    static {

        Farmer.PersonalInfoBean b1 = new Farmer.PersonalInfoBean("Jack", "Jack1111@qq.com", "123123523");
        Farmer.PersonalInfoBean b2 = new Farmer.PersonalInfoBean("Tom", "TomTom@qq.com", "1145768");
        Farmer.PersonalInfoBean b4 = new Farmer.PersonalInfoBean("Leo", "qwert@qq.com", "44473345");
        Farmer.PersonalInfoBean b5 = new Farmer.PersonalInfoBean("David", "ahhhsefh@qq.com", "56756754");
        Farmer.PersonalInfoBean b6 = new Farmer.PersonalInfoBean("Com", "adfasdf@qq.com", "8576856");

        Farmer.FarmInfoBean f1 = new Farmer.FarmInfoBean("Farm_1", "beijing", "6678501", "http://www.farm_1.com");
        Farmer.FarmInfoBean f22 = new Farmer.FarmInfoBean("Farm_2", "hubei", "9929375", "http://www.farm_2.com");
        Farmer.FarmInfoBean f3 = new Farmer.FarmInfoBean("Farm_3", "nanning", "8772323", "http://www.farm_3.com");
        Farmer.FarmInfoBean f4 = new Farmer.FarmInfoBean("Farm_3", "yunnan", "2379423", "http://www.farm_4.com");

        List<String> d = new ArrayList<>();
        d.add("chongqing China");
        d.add("beijing China");

        Farmer ff1 = new Farmer(0, f3, b1, d);
        Farmer ff2 = new Farmer(1, f1, b4, d);
        Farmer ff3 = new Farmer(2, f22, b2, d);
        Farmer ff4 = new Farmer(4, f4, b6, d);
        Farmer ff5 = new Farmer(3, f22, b5, d);
        Farmer ff6 = new Farmer(123, f22, b1, d);

        map.put(ff1.getFid(),ff1);
        map.put(ff2.getFid(),ff2);
        map.put(ff3.getFid(),ff3);
        map.put(ff4.getFid(),ff4);
        map.put(ff5.getFid(),ff5);
        map.put(ff6.getFid(),ff6);

        delivery_charge.put(ff1,2.53);
        delivery_charge.put(ff2,3.83);
        delivery_charge.put(ff3,7.13);
        delivery_charge.put(ff4,6.33);
        delivery_charge.put(ff5,3.81);

    }

    public static Farmer get(String id) {

        Integer i = null;

        try {
            i = Integer.parseInt(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return map.get(i);
    }

    public static void addPrice(Farmer farmer, Double price){
        delivery_charge.put(farmer,price);
    }

    public static Double getPrice(Farmer farmer){
        return delivery_charge.get(farmer);
    }

    public static List<Farmer> getAllFarmer() {

        List<Farmer> list = new ArrayList<>();


        for(Map.Entry<Integer,Farmer> en : map.entrySet()){
            list.add(en.getValue());
        }


        return list;
    }
}
