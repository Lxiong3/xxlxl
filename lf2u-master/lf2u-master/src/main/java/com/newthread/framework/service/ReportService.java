package com.newthread.framework.service;

import com.newthread.framework.model.ReportPart;

import java.util.List;


public interface ReportService {
    List<ReportPart> getReport(String frid);


    int updateCharge(String fid, Double delivery_charge);

    Double getPrice(String fid);
}
