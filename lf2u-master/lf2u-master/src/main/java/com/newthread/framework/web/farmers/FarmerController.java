package com.newthread.framework.web.farmers;

import com.newthread.framework.entity.Farmer;
import com.newthread.framework.entity.Products;
import com.newthread.framework.exception.ArgumentsException;
import com.newthread.framework.service.FarmersService;
import com.newthread.framework.util.MessageMaker;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@RestController
public class FarmerController {

    private final Logger logger = Logger.getLogger(this.getClass());

    @Resource
    private FarmersService service;

    @RequestMapping(value = "/farmers", method = RequestMethod.POST)
    public Object createAccount(@RequestBody Farmer farmer) throws ArgumentsException {

        logger.info(farmer);


        int x = service.createFarm(farmer);


        if (farmer == null || x == 0) {
            throw new ArgumentsException();
        }

        return MessageMaker.make(farmer.getFid());
    }

    @RequestMapping(value = "/farmers/{fid}", method = RequestMethod.PUT)
    public Object updateAccount(@RequestBody Farmer farmer, @PathVariable(value = "fid") Integer fid) {


        farmer = service.update(farmer);

        if (farmer == null) {
            return MessageMaker.make("E01", "NO THIS FARMERS", null);
        }

        return MessageMaker.make(farmer.getFid());
    }

    @RequestMapping(value = "/farmers/{fid}", method = RequestMethod.GET)
    public Object getAccount(@PathVariable(value = "fid") Integer fid) {

        Farmer f = service.getFarmer(fid);

        if (f == null) {
            return MessageMaker.make("E02", "NO THIS FARMERS", null);
        }

        return f;
    }

    @RequestMapping(value = "/farmers", method = RequestMethod.GET)
    public Object getAccountZip(@RequestParam Integer zip) {

        // TODO: 2016/11/15

        return null;
    }

    @RequestMapping(value = "/farmers/{fid}/products", method = RequestMethod.GET)
    public Object getAccountProducts(@PathVariable Integer fid) {

        // TODO: 2016/11/15
        List<Products> list = service.getProducts(fid);

        if (list == null || list.size() == 0) {
            return MessageMaker.make("E02", "NO Products", null);
        }

        return list;
    }

    @RequestMapping(value = "/farmers/{fid}/products", method = RequestMethod.POST)
    public Object addAccountProducts(@PathVariable Integer fid, @RequestBody Products p) {


        String fspid = service.addProduces(fid, p);

        if (fspid == null) {
            return MessageMaker.make("E02", "Add Products Error,No This User", null);
        }

        return MessageMaker.makeFspid(fspid);
    }

    @RequestMapping(value = "/farmers/{fid}/products/{fspid}", method = RequestMethod.POST)
    public Object updateAccountProducts(@PathVariable Integer fid, @PathVariable String fspid, @RequestBody(required = false) Products p) {

        if (p != null){
            p.setFspid(fspid);
        }

        String result = service.updateParticalProducts(fid,p);

        if (result == null) {
            return MessageMaker.make("E02", "Please enter the update value or enter the correct products id !", null);
        }

        return result;
    }


    @RequestMapping(value = "/farmers/{fid}/products/{fspid}", method = RequestMethod.GET)
    public Object getAccountProducts(@PathVariable Integer fid, @PathVariable String fspid) {


        Products products = service.getProductsByFsid(fid,fspid);

        if (products == null) {
            return MessageMaker.make("E02", "no have the products !", null);
        }

        return products;
    }

}
