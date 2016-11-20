package com.newthread.service;

import com.newthread.mapper.ManagerMapper;
import com.newthread.mapper.ManagerReportMapper;
import com.newthread.mapper.OrdersMapper;
import com.newthread.model.ManagerReportPartPlus;
import com.newthread.domain.Catalog;
import com.newthread.domain.Manager;
import com.newthread.domain.ManagerReport;
import com.newthread.domain.Orders;
import com.newthread.mapper.CatalogMapper;
import com.newthread.model.ManagerReportPart;
import com.newthread.util.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@Service
public class ManagerServiceImpl implements ManagerService {

    @Resource
    private ManagerMapper managerMapper;
    @Resource
    private CatalogMapper catalogMapper;
    @Resource
    private ManagerReportMapper managerReportMapper;
    @Resource
    private OrdersMapper ordersMapper;

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

            catalogMapper.insert(catalog);

            return catalog.getGcpid();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Manager> getAllManager() {
        return managerMapper.selectAll();
    }

    @Override
    public Manager getManager(String mid) {

        return managerMapper.selectByPrimaryKey(mid);
    }

    @Override
    public List<ManagerReportPart> getAllReport() {

        List<ManagerReport> list = managerReportMapper.selectAll();

        if (list == null) {
            return null;
        }

        List<ManagerReportPart> l = new ArrayList<>();

        ManagerReportPart part = null;

        for (ManagerReport report : list) {
            part = new ManagerReportPart();
            part.setMrid(report.getMid());
            part.setName(report.getName());
            l.add(part);
        }

        return l;
    }

    @Override
    public String updateDelivery(String oid, String delivery) {

        Orders orders = ordersMapper.selectByPrimaryKey(oid);

        if (orders == null) {
            return null;
        }
        orders.setStatus(delivery);
        ordersMapper.updateByPrimaryKey(orders);

        return orders.getStatus();
    }

    @Override
    public List<ManagerReport> getReport(String mrid) {
        return managerReportMapper.selectByManagerId(mrid);
    }

    @Override
    public List<ManagerReportPartPlus> getReportPlus(String mrid) {
        List<ManagerReport> list = managerReportMapper.selectAll();

        if (list == null) {
            return null;
        }

        List<ManagerReportPartPlus> l = new ArrayList<>();

        ManagerReportPartPlus part = null;

        for (ManagerReport report : list) {
            part = new ManagerReportPartPlus();
            part.setMrid(report.getMid());
            part.setName(report.getName());
            part.setOrders_cancelled(report.getOrdersCancelled());
            part.setOrders_delivered(report.getOrdersDelivered());
            part.setOrders_open(report.getOrdersOpen());
            part.setOrders_placed(report.getOrdersPlaced());
            l.add(part);
        }

        return l;
    }
}
