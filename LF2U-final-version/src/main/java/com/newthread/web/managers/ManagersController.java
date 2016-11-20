package com.newthread.web.managers;

import com.newthread.domain.FarmerReport;
import com.newthread.exception.ArgumentsException;
import com.newthread.exception.NoSuchCatalogException;
import com.newthread.exception._404Exception;
import com.newthread.model.*;
import com.newthread.service.CustomersService;
import com.newthread.service.FarmersService;
import com.newthread.service.ManagerService;
import com.newthread.domain.Manager;
import com.newthread.service.CatalogService;
import com.newthread.util.MessageMaker;
import com.sun.xml.internal.xsom.impl.ListSimpleTypeImpl;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@RestController
public class ManagersController {

    private final Logger logger = Logger.getLogger(this.getClass());

    @Resource
    private ManagerService service;

    @Resource
    private CustomersService customerService;

    @Resource
    private FarmersService farmerService;

    @Resource
    private CatalogService catalogService;

    @RequestMapping(value = "/managers/catalog", method = RequestMethod.GET)
    public Object catalog() {
        return catalogService.getAllCatalog();

    }


    @RequestMapping(value = "/managers/catalog", method = RequestMethod.POST)
    public Object o(@RequestBody Map<String, String> map) {

        String name = map.get("name");

        if (name == null) {
            return null;
        }

        String gcpid = service.addCatalog(name);

        return "{\"gcpid\":" + gcpid + "}";

    }

    @RequestMapping(value = "/managers/accounts", method = RequestMethod.GET)
    public Object ddd() {

        return service.getAllManager();

    }


    @RequestMapping(value = "/managers/accounts/{mid}", method = RequestMethod.GET)
    public Object dddasdf(@PathVariable String mid) {

        Manager m = service.getManager(mid);

        if (m == null) {
            return MessageMaker.make("E02", "NO THIS managers", null);
        }

        return m;

    }


    @RequestMapping(value = "/managers/reports", method = RequestMethod.GET)
    public Object report() {

        List<ManagerReportPart> m = service.getAllReport();

        if (m == null) {
            return MessageMaker.make("E02", "empty list !", null);
        }

        return m;

    }


    @RequestMapping(value = "/managers/reports/{mrid}", method = RequestMethod.GET)
    public Object report(@PathVariable String mrid, Integer start_time, Integer end_time) {

        if (start_time == null || end_time == null) {

            List<ManagerReportPartPlus> m = service.getReportPlus(mrid);
            if (m == null) {
                return MessageMaker.make("E02", "empty list !", null);
            }
            return m;

        } else {

            // TODO: 2016/11/15


            return null;
        }


    }


    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public Object search(@RequestParam String topic, @RequestParam String key) {

        //// TODO: 2016/11/15
        if (topic.equals("farm")) {
            return farmerService.search(key);
        } else if (topic.equals("customer")) {
            return customerService.searchCustomer(key);
        } else if (topic.equals("order")) {
            return customerService.search(key);
        }


        return null;
    }


    @RequestMapping(value = "/delivery/{oid}", method = RequestMethod.POST)
    public Object delivery(@PathVariable String oid, @RequestBody Map<String, String> map) {

        String delivery = map.get("status");

        if (delivery == null) {
            return MessageMaker.make("E02", "NO This Order Or this values is incorrect !", null);
        }

        String status = service.updateDelivery(oid, delivery);

        return "{\"status\":" + status + "}";

    }

    @RequestMapping(value = "/gggggg", method = RequestMethod.GET)
    public Object delivery() {
        List<Object> list = new ArrayList<>();

        list.add(new _404Exception());
        list.add(new ArgumentsException());
        list.add(new NoSuchCatalogException());
        list.add(new FarmerReport());
        list.add(new FarmerRegisterModel());
        list.add(new OrderModel());
        list.add(new OrderResponse());
        list.add(new Response());
        list.add(new ZipObj());
        list.add(new OrderModel());
        list.add(new OrderModel());

        for (Object s : list){
            logger.info(s);
        }

        return list;
    }

}
