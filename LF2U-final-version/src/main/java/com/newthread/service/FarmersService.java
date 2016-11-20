package com.newthread.service;

import com.newthread.domain.Farm;
import com.newthread.domain.Farmer;
import com.newthread.domain.Product;
import com.newthread.exception.NoSuchCatalogException;
import com.newthread.model.FarmerRegisterModel;
import com.newthread.model.ZipObj;

import java.util.List;


public interface FarmersService {


    public String createFarm(Farm farm);

    String createFarm(Farmer farmer);

    Farmer update(Farmer farmer);

    Farmer getFarmer(String fid);

    List<Product> getProducts(String fid);

    String addProduces(String fid, Product p) throws NoSuchCatalogException;

    String updateParticalProducts(String fid, Product p);

    Product getProductsByFsid(String fid, String fspid);

    List<Farmer> search(String key);

    String createFarm(FarmerRegisterModel farmer);

    List<ZipObj> getAllFarmerInfoByZip(Integer zip);

    String update(String fid,FarmerRegisterModel farmer);

    FarmerRegisterModel getFarmerInfo(String fid);
}
