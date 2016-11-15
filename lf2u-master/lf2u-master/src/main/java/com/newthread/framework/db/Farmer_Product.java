package com.newthread.framework.db;

import com.newthread.framework.entity.Farmer;
import com.newthread.framework.entity.Products;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Farmer_Product {

    public static Map<Farmer, List<Products>> map = new HashMap<>();

    static {

        for (Map.Entry<Integer, Farmer> entry : FarmerDB.map.entrySet()) {

            List<Products> l = new ArrayList<>();
            Products p = ProductDB.randomGet();
            if(p != null){
                l.add(p);
            }
            Products p2 = ProductDB.randomGet();
            if(p2 != null){
                l.add(p2);
            }
            map.put(entry.getValue(), l);
        }


    }

    public static void put(Farmer farmer, Products products) {

        List<Products> l = map.get(farmer);
        //new
        if (!map.containsKey(farmer) || l == null) {
            l = new ArrayList<>();
            l.add(products);
            map.put(farmer, l);
        }
        //has before
        l.add(products);
    }


    public static List<Products> get(Farmer f) {
        return map.get(f);
    }
}
