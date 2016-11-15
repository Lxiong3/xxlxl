package com.newthread.framework.service;

import com.newthread.framework.db.FarmerDB;
import com.newthread.framework.db.Farmer_ReportDB;
import com.newthread.framework.db.ReportDB;
import com.newthread.framework.entity.Farmer;
import com.newthread.framework.entity.Report;
import com.newthread.framework.model.ReportPart;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ReportServiceImpl implements ReportService {

    @Override
    public List<ReportPart> getReport(String frid) {

        Farmer farmer = FarmerDB.get(frid);

        if (farmer == null){
            return null;
        }

        List<Report> list = Farmer_ReportDB.getReport(farmer);

        if(list == null || list.size() == 0){
            return null;
        }

        List<ReportPart> l = new ArrayList<>();

        ReportPart p = null;

        for(Report r : list){
            p = new ReportPart();
            p.setName(r.getName());
            p.setFrid(r.getFrid());
            l.add(p);
        }

        return l;
    }

    @Override
    public int updateCharge(String fid, Double delivery_charge) {

        Farmer farmer = FarmerDB.get(fid);

        if(farmer == null ){
            return 0;
        }

        FarmerDB.addPrice(farmer,delivery_charge);


        return 1;
    }

    @Override
    public Double getPrice(String fid) {
        Farmer farmer = FarmerDB.get(fid);

        if(farmer == null ){
            return null;
        }
        return FarmerDB.getPrice(farmer);
    }
}
