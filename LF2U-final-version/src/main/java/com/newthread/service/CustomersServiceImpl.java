package com.newthread.service;

import com.newthread.domain.Customer;
import com.newthread.domain.Orders;
import com.newthread.mapper.CustomerMapper;
import com.newthread.mapper.OrdersMapper;
import com.newthread.model.OrderModel;
import com.newthread.model.OrderResponse;
import com.newthread.model.RegisterModel;
import com.newthread.util.StringUtil;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@Service
public class CustomersServiceImpl implements CustomersService {
    private final Logger logger = Logger.getLogger(this.getClass());
    @Resource
    CustomerMapper customerMapper;
    @Resource
    OrdersMapper orderMapper;

    @Override
    public String create(RegisterModel model) {

        Customer customer = new Customer();
        customer.setCid(StringUtil.randomInteger() + "");
        customer.setName(model.getName());
        customer.setEmail(model.getEmail());
        customer.setPhone(model.getPhone());
        customer.setStreet(model.getStreet());
        customer.setZip(model.getZip());

        customerMapper.insert(customer);

        return customer.getCid();
    }

    @Override
    public String update(String cid, RegisterModel model) {

        Customer customer = customerMapper.selectByPrimaryKey(cid);
        customer.setName(model.getName());
        customer.setEmail(model.getEmail());
        customer.setPhone(model.getPhone());
        customer.setStreet(model.getStreet());
        customer.setZip(model.getZip());

        return customer.getCid();
    }

    @Override
    public Customer get(String cid) {
        return customerMapper.selectByPrimaryKey(cid);
    }

    @Override
    public String createOrder(String cid, OrderModel model) {


        if (cid == null || model == null) {
            return null;
        }

        Orders orders = new Orders();

        orders.setFrid(model.getFid());

        //get product price and plus  --> total price

        orders.setStatus(" no delivery ");
        orders.setOrderTotal(123d);
        orders.setNote(model.getDelivery_note());
        orders.setOid(StringUtil.randomString());
        orders.setOrderedBy(cid);
        orders.setOrderDate(StringUtil.getDate());
        orders.setPlannedDeliveryDate(StringUtil.getDate());
        orders.setActualDeliveryDate(StringUtil.getDate());
        orderMapper.insert(orders);

        return orders.getOid();
    }

    @Override
    public List<OrderResponse> getOrder(String cid) {

        List<Orders> list = orderMapper.selectAllByCid(cid);

        OrderResponse response = null;

        List<OrderResponse> l = new ArrayList<>();

        for (Orders order : list) {
            logger.info(order);
            response = new OrderResponse();
            response.setOid(order.getOid());
            response.setOrder_date(order.getOrderDate() + "");
            response.setPlanned_delivery_date(order.getPlannedDeliveryDate() + "");
            response.setActual_delivery_date(order.getActualDeliveryDate() + "");
            response.setStatus(order.getStatus());
            response.setFid(order.getOrderedBy());
            l.add(response);
        }
        return l;
    }

    @Override
    public Orders getDetailOrder(String cid, String oid) {

        List<Orders> list = orderMapper.selectAllByCid(cid);

        for (Orders order : list) {

            if (order.getOid().equals(oid)) {
                return order;
            }

        }

        return null;
    }

    @Override
    public String updateOrder(String cid, String oid, String status) {

        Orders orders = orderMapper.selectByPrimaryKey(oid);

        orders.setStatus(status);

        orderMapper.updateByPrimaryKey(orders);

        return status;
    }

    @Override
    public Object search(String key) {


        for (Orders o : orderMapper.selectAll()) {
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
