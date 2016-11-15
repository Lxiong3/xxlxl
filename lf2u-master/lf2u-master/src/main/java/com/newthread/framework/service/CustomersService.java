package com.newthread.framework.service;

import com.newthread.framework.entity.Customer;
import com.newthread.framework.entity.Order;
import com.newthread.framework.model.OrderModel;
import com.newthread.framework.model.RegisterModel;
import com.newthread.framework.web.customers.OrderResponse;

import java.util.List;


public interface CustomersService {
    String create(RegisterModel model);

    String update(String cid, RegisterModel model);

    Customer get(String cid);

    String createOrder(String cid,OrderModel model);

    List<OrderResponse> getOrder(String cid);

    Order getDetailOrder(String cid, String oid);


    String updateOrder(String cid, String oid, String status);

    Object search(String key);

    Customer searchCustomer(String key);
}
