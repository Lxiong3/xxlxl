package com.newthread.framework.service;

import com.newthread.framework.db.CatalogDB;
import com.newthread.framework.db.MangerDB;
import com.newthread.framework.db.OrderDB;
import com.newthread.framework.db.ReportDB;
import com.newthread.framework.entity.Catalog;
import com.newthread.framework.entity.ManagerReport;
import com.newthread.framework.entity.Manger;
import com.newthread.framework.entity.Order;
import com.newthread.framework.util.StringUtil;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ManagerServiceImpl implements ManagerService {
    @Override
    public int createFarm() {
        return 0;
    }

    @Override
    public String addCatalog(String name) {
        try {

            Catalog catalog = new Catalog();

            catalog.setGcpid(StringUtil.randomInteger() + "");
            catalog.setName(name);

            CatalogDB.list.add(catalog);

            return catalog.getGcpid();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Manger> getAllManger() {
        return MangerDB.list;
    }

    @Override
    public Manger getManger(String mid) {

        for (Manger m : MangerDB.list) {
            if (m.getMid().equals(mid)) {
                return m;
            }
        }

        return null;
    }

    @Override
    public List<ManagerReport> getAllReport() {
        return ReportDB.getAllManagerReport();
    }

    @Override
    public String updateDelivery(String oid, String delivery) {

        for (Order m : OrderDB.getAllOrder()) {
            if (m.getOid().equals(oid)) {
                m.setStatus("delivered");
                return m.getStatus();
            }
        }
        return null;
    }
}
