package com.newthread.service;

import com.newthread.domain.Orders;
import com.newthread.domain.Product;
import com.newthread.mapper.FarmerMapper;
import com.newthread.mapper.FarmerReportMapper;
import com.newthread.mapper.OrdersMapper;
import com.newthread.mapper.ProductMapper;
import com.newthread.model.ReportPart;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class ReportServiceImpl implements ReportService {

    @Resource
    private FarmerMapper farmerMapper;
    @Resource
    private FarmerReportMapper farmerReportMapper;
    @Resource
    private ProductMapper productMapper;
    @Resource
    private OrdersMapper ordersMapper;


    @Override
    public ReportPart getReport(String frid) {

        ReportPart reportPart = farmerReportMapper.selectByFrid(frid);

        if (reportPart == null) {
            return null;
        }

        List<Orders> list = ordersMapper.selectByFarmerId(frid);

        reportPart.setOrders(list);

        return reportPart;
    }

    @Override
    public int updateCharge(String fspid, Double charge) {

        Product product = productMapper.selectByPrimaryKey(fspid);

        if (product == null) {
            return 0;
        }

        product.setPrice(charge);

        productMapper.updateByPrimaryKey(product);

        return 1;
    }

    @Override
    public Double getPrice(String fspid) {
        return productMapper.selectPriceByFspid(fspid);
    }
}
