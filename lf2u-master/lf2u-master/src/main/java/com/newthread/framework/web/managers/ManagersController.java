package com.newthread.framework.web.managers;

import com.newthread.framework.db.CatalogDB;
import com.newthread.framework.entity.ManagerReport;
import com.newthread.framework.entity.Manger;
import com.newthread.framework.service.CustomersService;
import com.newthread.framework.service.FarmersService;
import com.newthread.framework.service.ManagerService;
import com.newthread.framework.util.MessageMaker;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.crypto.spec.DESedeKeySpec;
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


    @RequestMapping(value = "/managers/catalog", method = RequestMethod.GET)
    public Object catalog() {


        return CatalogDB.list;

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

        List<Manger> list = service.getAllManger();

        return list;

    }


    @RequestMapping(value = "/managers/accounts/{mid}", method = RequestMethod.GET)
    public Object dddasdf(@PathVariable String mid) {

        Manger m = service.getManger(mid);

        if (m == null) {
            return MessageMaker.make("E02", "NO THIS managers", null);
        }

        return m;

    }


    @RequestMapping(value = "/managers/reports", method = RequestMethod.GET)
    public Object report() {

        List<ManagerReport> m = service.getAllReport();

        if (m == null) {
            return MessageMaker.make("E02", "empty list !", null);
        }

        return m;

    }


    @RequestMapping(value = "/managers/reports/{mrid}", method = RequestMethod.GET)
    public Object report(@PathVariable String mrid, Integer start_time, Integer end_time) {

        if (start_time == null || end_time == null) {

            List<ManagerReport> m = service.getAllReport();
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
    public Object delivery(@PathVariable String oid,@RequestBody Map<String, String> map) {

        String delivery = map.get("delivery");

        if (delivery == null) {
            return null;
        }

        String status = service.updateDelivery(oid,delivery);

        return "{\"status\":" + status + "}";

    }

}
