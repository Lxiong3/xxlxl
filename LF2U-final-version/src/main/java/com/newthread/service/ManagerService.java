package com.newthread.service;

import com.newthread.model.ManagerReportPartPlus;
import com.newthread.domain.Manager;
import com.newthread.domain.ManagerReport;
import com.newthread.model.ManagerReportPart;

import java.util.List;


public interface ManagerService {

    int createFarm();

    String addCatalog(String name);

    List<Manager> getAllManager();

    Manager getManager(String mid);

    List<ManagerReportPart> getAllReport();

    String updateDelivery(String oid, String delivery);

    List<ManagerReport> getReport(String mrid);

    List<ManagerReportPartPlus> getReportPlus(String mrid);
}
