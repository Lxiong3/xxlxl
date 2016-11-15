package com.newthread.framework.service;

import com.newthread.framework.entity.ManagerReport;
import com.newthread.framework.entity.Manger;

import java.util.List;


public interface ManagerService {
    int createFarm();

    String addCatalog(String name);

    List<Manger> getAllManger();

    Manger getManger(String mid);

    List<ManagerReport> getAllReport();

    String updateDelivery(String oid, String delivery);
}
