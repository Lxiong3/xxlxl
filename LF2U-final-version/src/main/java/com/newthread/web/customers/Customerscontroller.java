package com.newthread.web.customers;

import com.newthread.domain.Customer;
import com.newthread.domain.Orders;
import com.newthread.exception._404Exception;
import com.newthread.model.OrderModel;
import com.newthread.model.OrderResponse;
import com.newthread.model.RegisterModel;
import com.newthread.service.CustomersService;
import com.newthread.util.MessageMaker;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@RestController
public class Customerscontroller {

    private final Logger logger = Logger.getLogger(this.getClass());

    @Resource
    private CustomersService service;

    @RequestMapping(value = "/customers", method = RequestMethod.POST)
    public Object create(@RequestBody RegisterModel model, HttpServletResponse response) {

        logger.info(model);

        if (model == null || model.getEmail() == null || model.getName() == null || model.getPhone() == null || model.getZip() == null || model.getStreet() == null) {
            return MessageMaker.make("E02", "Please enter the correct form !", null);
        }

        String result = service.create(model);

        response.setHeader("Location", "/customers/" + result);

        return "{\"cid\":" + result + "}";
    }


    @RequestMapping(value = "/customers/{cid}", method = RequestMethod.PUT)
    public Object put(@PathVariable String cid, @RequestBody RegisterModel model, HttpServletResponse response) {

        if (model == null || model.getEmail() == null || model.getName() == null || model.getPhone() == null || model.getZip() == null || model.getStreet() == null) {
            return MessageMaker.make("E02", "Please enter the correct form !", null);
        }

        String result = service.update(cid, model);

        response.setHeader("Location", "/customers/" + result);

        return "{\"cid\":" + result + "}";
    }

    @RequestMapping(value = "/customers/{cid}", method = RequestMethod.GET)
    public Object get(@PathVariable String cid) throws _404Exception {


        Customer result = service.get(cid);

        if (result == null) {
            throw new _404Exception();
        }
        return result;
    }


    @RequestMapping(value = "/customers/{cid}/orders", method = RequestMethod.POST)
    public Object createOrder(@PathVariable String cid, @RequestBody OrderModel model, HttpServletResponse response) throws _404Exception {

        String orderId = service.createOrder(cid, model);

        if (orderId == null) {
            return MessageMaker.make("E02", "could not make the order !", null);
        }

        response.setHeader("Location", "/customers/" + cid + "/orders/" + orderId);

        return "{\"oid\": " + orderId + "}";
    }

    @RequestMapping(value = "/customers/{cid}/orders", method = RequestMethod.GET)
    public Object getOrder(@PathVariable String cid) throws _404Exception {

        List<OrderResponse> list = service.getOrder(cid);

        if (list == null || list.size() == 0) {
            return MessageMaker.make("E02", "no order !", null);
        }

        return list;
    }


    @RequestMapping(value = "/customers/{cid}/orders/{oid}", method = RequestMethod.GET)
    public Object ggggg(@PathVariable String cid, @PathVariable String oid) throws _404Exception {
        // TODO: 2016/11/15  need update
        Orders order = service.getDetailOrder(cid, oid);

        if (order == null) {
            return MessageMaker.make("E02", "no order !", null);
        }

        return order;
    }


    @RequestMapping(value = "/customers/{cid}/orders/{oid}", method = RequestMethod.POST)
    public Object updateOrders(@PathVariable String cid, @PathVariable String oid, @RequestBody Map map) throws _404Exception {

        String status = (String) map.get("status");

        String orderId = service.updateOrder(cid, oid, status);

        if (orderId == null) {
            return MessageMaker.make("E02", "could not update the order !", null);
        }

        return "{\"oid\": " + orderId + "}";
    }

}
