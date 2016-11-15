package com.newthread.framework.db;

import com.newthread.framework.entity.Farmer;
import com.newthread.framework.entity.Report;

import java.util.*;


public class Farmer_ReportDB {

    public static Map<Farmer, List<Report>> map = new HashMap<>();

    static {


        for (Map.Entry<Integer, Farmer> entry : FarmerDB.map.entrySet()) {

            Farmer farmer = entry.getValue();

            List<Report> list = new ArrayList<>();

            Report r1 = ReportDB.getRandom();
            if (r1 != null) {
                list.add(r1);
            }
            Report r2 = ReportDB.getRandom();
            if (r2 != null) {
                list.add(r2);
            }
            Report r3 = ReportDB.getRandom();
            if (r3 != null) {
                list.add(r3);
            }

            Collections.sort(list);

            map.put(farmer, list);

        }


    }

    public static List<Report> getReport(Farmer f) {
        return  map.get(f);
    }
}
