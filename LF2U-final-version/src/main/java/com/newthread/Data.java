package com.newthread;

import com.newthread.domain.DeliversTo;
import com.newthread.domain.FarmerReport;
import com.newthread.exception.ArgumentsException;
import com.newthread.exception.NoSuchCatalogException;
import com.newthread.exception._404Exception;
import com.newthread.model.*;


public class Data {

    public static Double delivery_charge = 1.0;

    public static Object getData(){
        new DeliversTo();
        new _404Exception();
        new ArgumentsException();
        new NoSuchCatalogException();
        new FarmerReport();
        new FarmerRegisterModel();
        new OrderModel();
        new OrderResponse();
        new Response();
        new ZipObj();
        new OrderModel();
        new OrderModel();

        return null;
    }

}
