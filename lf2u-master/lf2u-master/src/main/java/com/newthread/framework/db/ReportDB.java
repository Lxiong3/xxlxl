package com.newthread.framework.db;

import com.newthread.framework.entity.ManagerReport;
import com.newthread.framework.entity.Report;
import com.newthread.framework.util.StringUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ReportDB {

    public static Map<String, Report> map = new HashMap<>();

    //mrid
    public static Map<String, ManagerReport> managerReportMap = new HashMap<>();

    static {

        Report r1 = new Report("701", "Orders to deliver today", "");
        Report r2 = new Report("702", "Orders to deliver tomorrow", "");
        Report r3 = new Report("703", "Revenue report", "");
        Report r4 = new Report("704", "Orders delivery report", "");
        Report r5 = new Report("705", "Revenue report", "");
        Report r6 = new Report("706", "Orders delivery report", "");

        map.put(r1.getFrid(), r1);
        map.put(r2.getFrid(), r2);
        map.put(r3.getFrid(), r3);
        map.put(r4.getFrid(), r4);
        map.put(r5.getFrid(), r5);
        map.put(r6.getFrid(), r6);


        ManagerReport q1 = new ManagerReport();
        q1.setName("Orders placed yesterday");
        q1.setMrid("2");
        ManagerReport q2 = new ManagerReport();
        q2.setName("Revenue for previous month");
        q2.setMrid("1");
        ManagerReport q3 = new ManagerReport();
        q3.setName("Revenue yesterday by zip code");
        q3.setMrid("3");

        managerReportMap.put(q1.getMrid(), q1);
        managerReportMap.put(q2.getMrid(), q2);
        managerReportMap.put(q3.getMrid(), q3);
    }

    public static Report getRandom() {

        for (Map.Entry<String, Report> m : map.entrySet()) {
            if (StringUtil.randomBoolean()) {
                return m.getValue();
            }
        }
        return null;
    }

    public static List<ManagerReport> getAllManagerReport() {

        List<ManagerReport> list = new ArrayList<>();

        for (Map.Entry<String, ManagerReport> e : managerReportMap.entrySet()) {
            list.add(e.getValue());
        }
        return list;


    }

}
