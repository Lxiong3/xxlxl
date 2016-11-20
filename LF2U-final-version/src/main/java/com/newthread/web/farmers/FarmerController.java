package com.newthread.web.farmers;

import com.newthread.service.FarmersService;
import com.newthread.domain.Product;
import com.newthread.exception.ArgumentsException;
import com.newthread.exception.NoSuchCatalogException;
import com.newthread.model.FarmerRegisterModel;
import com.newthread.model.ZipObj;
import com.newthread.util.MessageMaker;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@RestController
public class FarmerController {

    private final Logger logger = Logger.getLogger(this.getClass());

    @Resource
    private FarmersService service;

    @RequestMapping(value = "/farmers", method = RequestMethod.POST)
    public Object createAccount(@RequestBody FarmerRegisterModel farmer, HttpServletResponse response) throws ArgumentsException {

        logger.info(farmer);

        //if fid is null return this x
        String x = service.createFarm(farmer);

        if (farmer == null) {
            throw new ArgumentsException();
        }

        response.addHeader("Location", "/farmers/" + x);

        return MessageMaker.makeFid(x);
    }

    @RequestMapping(value = "/farmers/{fid}", method = RequestMethod.PUT)
    public Object updateAccount(@RequestBody FarmerRegisterModel farmer, @PathVariable(value = "fid") String fid) {

        String updateResult = service.update(fid, farmer);

        if (farmer == null) {
            return MessageMaker.make("E01", "NO THIS FARMERS", null);
        }

        return MessageMaker.makeFid(updateResult);
    }

    @RequestMapping(value = "/farmers/{fid}", method = RequestMethod.GET)
    public Object getAccount(@PathVariable(value = "fid") String fid) {

        FarmerRegisterModel model = service.getFarmerInfo(fid);

        if (model == null) {
            return MessageMaker.make("E02", "NO THIS FARMERS", null);
        }

        return model;
    }

    @RequestMapping(value = "/farmers", method = RequestMethod.GET)
    public Object getAccountZip(@RequestParam Integer zip) {

        List<ZipObj> list = service.getAllFarmerInfoByZip(zip);

        if (list == null || list.size() == 0) {
            return MessageMaker.make("E02", "NO People live here !", null);
        }

        return list;
    }

    @RequestMapping(value = "/farmers/{fid}/products", method = RequestMethod.GET)
    public Object getAccountProducts(@PathVariable String fid) {
// TODO: 2016/11/19  待测试
        List<Product> list = service.getProducts(fid);

        return list;
    }

    @RequestMapping(value = "/farmers/{fid}/products", method = RequestMethod.POST)
    public Object addAccountProducts(@PathVariable String fid, @RequestBody Product p) {

// TODO: 2016/11/19 待测试 
        String fspid = null;
        try {
            fspid = service.addProduces(fid, p);
        } catch (NoSuchCatalogException e) {
            return MessageMaker.make("E02", "No Such Catalog !", null);
        }


        if (fspid == null) {
            return MessageMaker.make("E02", "Add Products Error,No This User", null);
        }

        return MessageMaker.makeFspid(fspid);
    }

    @RequestMapping(value = "/farmers/{fid}/products/{fspid}", method = RequestMethod.POST)
    public Object updateAccountProducts(@PathVariable String fid, @PathVariable String fspid, @RequestBody(required = false) Product p) {

        if (p != null) {
            p.setFspid(fspid);
        }

        String result = service.updateParticalProducts(fid, p);

        if (result == null) {
            return MessageMaker.make("E02", "Please enter the update value or enter the correct products id !", null);
        }

        return MessageMaker.makeFspid(result);
    }


    @RequestMapping(value = "/farmers/{fid}/products/{fspid}", method = RequestMethod.GET)
    public Object getAccountProducts(@PathVariable String fid, @PathVariable String fspid) {

        Product products = service.getProductsByFsid(fid, fspid);

        if (products == null) {
            return MessageMaker.make("E02", "no have the products !", null);
        }

        return products;
    }

}
