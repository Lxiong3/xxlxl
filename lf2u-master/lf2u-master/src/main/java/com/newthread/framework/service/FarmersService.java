package com.newthread.framework.service;

import com.newthread.framework.entity.Farm;
import com.newthread.framework.entity.Farmer;
import com.newthread.framework.entity.Products;

import java.util.List;


public interface FarmersService {
    int createFarm(Farmer farmer);

    Farmer update(Farmer farmer);

    Farmer getFarmer(Integer fid);

    List<Products> getProducts(Integer fid);

    String addProduces(Integer fid, Products p);


    String updateParticalProducts(Integer fid, Products p);

    Products getProductsByFsid(Integer fid, String fspid);

    List<Farmer> search(String key);
}
