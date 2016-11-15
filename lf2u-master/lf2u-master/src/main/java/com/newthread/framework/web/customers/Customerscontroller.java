package com.newthread.framework.web.customers;

import com.newthread.framework.entity.Customer;
import com.newthread.framework.entity.Order;
import com.newthread.framework.exception._404Exception;
import com.newthread.framework.model.OrderModel;
import com.newthread.framework.model.RegisterModel;
import com.newthread.framework.service.CustomersService;
import com.newthread.framework.util.MessageMaker;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;
import java.util.function.ToDoubleBiFunction;

@RestController
public class Customerscontroller {

    @Resource
    private CustomersService service;

    @RequestMapping(value = "/customers", method = RequestMethod.POST)
    public Object create(@RequestBody RegisterModel model, HttpServletResponse response) {

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
    public Object orders(@PathVariable String cid, @RequestBody OrderModel model, HttpServletResponse response) throws _404Exception {

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
        Order order = service.getDetailOrder(cid, oid);

        if (order == null) {
            return MessageMaker.make("E02", "no order !", null);
        }

        return order;
    }



    @RequestMapping(value = "/customers/{cid}/orders/{oid}", method = RequestMethod.POST)
    public Object orders(@PathVariable String cid,@PathVariable String oid, @RequestBody Map map) throws _404Exception {

        String status = (String) map.get("status");

        String orderId = service.updateOrder(cid,oid, status);

        if (orderId == null) {
            return MessageMaker.make("E02", "could not update the order !", null);
        }

        return "{\"oid\": " + orderId + "}";
    }

}
