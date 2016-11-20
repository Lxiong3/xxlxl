package com.newthread.service;

import com.newthread.model.OrderResponse;
import com.newthread.domain.Customer;
import com.newthread.domain.Orders;
import com.newthread.model.OrderModel;
import com.newthread.model.RegisterModel;

import java.util.List;


public interface CustomersService {
    String create(RegisterModel model);

    String update(String cid, RegisterModel model);

    Customer get(String cid);

    String createOrder(String cid,OrderModel model);

    List<OrderResponse> getOrder(String cid);

    Orders getDetailOrder(String cid, String oid);


    String updateOrder(String cid, String oid, String status);

    Object search(String key);

    Customer searchCustomer(String key);
}
