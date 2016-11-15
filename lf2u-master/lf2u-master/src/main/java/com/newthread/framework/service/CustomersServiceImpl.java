package com.newthread.framework.service;

import com.newthread.framework.db.CustomerDB;
import com.newthread.framework.db.OrderDB;
import com.newthread.framework.entity.Customer;
import com.newthread.framework.entity.Order;
import com.newthread.framework.model.OrderModel;
import com.newthread.framework.model.RegisterModel;
import com.newthread.framework.util.StringUtil;
import com.newthread.framework.web.customers.OrderResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CustomersServiceImpl implements CustomersService {


    @Override
    public String create(RegisterModel model) {

        Customer customer = new Customer();
        customer.setCid(StringUtil.randomInteger() + "");
        customer.setName(model.getName());
        customer.setEmail(model.getEmail());
        customer.setPhone(model.getPhone());
        customer.setStreet(model.getStreet());
        customer.setZip(model.getZip());

        CustomerDB.addCustomer(customer);

        return customer.getCid();
    }

    @Override
    public String update(String cid, RegisterModel model) {

        Customer customer = CustomerDB.getCustomer(cid);
        customer.setName(model.getName());
        customer.setEmail(model.getEmail());
        customer.setPhone(model.getPhone());
        customer.setStreet(model.getStreet());
        customer.setZip(model.getZip());

        return customer.getCid();
    }

    @Override
    public Customer get(String cid) {
        return CustomerDB.getCustomer(cid);
    }

    @Override
    public String createOrder(String cid, OrderModel model) {

        Order order = new Order();

        List<Order.OrderDetailBean> list = new ArrayList<>();

        for (OrderModel.OrderDetailBean bean : model.getOrder_detail()) {
            Order.OrderDetailBean detailBean = new Order.OrderDetailBean();
            detailBean.setFspid(Integer.parseInt(bean.getFspid()));
            detailBean.setPrice("63");
            list.add(detailBean);
        }

        order.setOid(StringUtil.randomInteger() + "");
        order.setFid(model.getFid());
        order.setNote(model.getDelivery_note());
        order.setOrder_detail(list);

        List<Order> map = new ArrayList<>();
        map.add(order);

        OrderDB.createOrder(cid, map);

        return order.getOid();
    }

    @Override
    public List<OrderResponse> getOrder(String cid) {

        List<Order> list = OrderDB.getorder(cid);

        OrderResponse response = null;

        List<OrderResponse> l = new ArrayList<>();

        for (Order order : list) {

            response = new OrderResponse();
            response.setOid(order.getOid());
            response.setOrder_date(order.getOrder_date());
            response.setPlanned_delivery_date(order.getPlanned_delivery_date());
            response.setActual_delivery_date(order.getActual_delivery_date());
            response.setStatus(order.getStatus());
            response.setFid(order.getFid());
            l.add(response);
        }
        return l;
    }

    @Override
    public Order getDetailOrder(String cid, String oid) {

        List<Order> list = OrderDB.getorder(cid);

        for (Order order : list) {

            if (order.getOid().equals(oid)) {
                return order;
            }

        }

        return null;
    }

    @Override
    public String updateOrder(String cid, String oid, String status) {


        List<Order> list = OrderDB.getorder(cid);

        if (list == null) {
            return null;
        }

        for (Order order : list) {

            if (order.getOid().equals(oid)) {
                order.setStatus(status);
                return order.getOid();
            }

        }
        return null;
    }

    @Override
    public Object search(String key) {


        for (Order o : OrderDB.getAllOrder()) {
            if (o.getOid().equals(key)) {
                return o;
            }
        }


        return null;
    }

    @Override
    public Customer searchCustomer(String key) {
        return null;
    }
}
