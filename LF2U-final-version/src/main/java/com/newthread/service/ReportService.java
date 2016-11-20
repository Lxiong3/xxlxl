package com.newthread.service;

import com.newthread.model.ReportPart;


public interface ReportService {

    ReportPart getReport(String fid);


    int updateCharge(String fspid, Double charge);

    Double getPrice(String fspid);
}
