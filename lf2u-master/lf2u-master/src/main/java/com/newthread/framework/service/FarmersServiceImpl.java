package com.newthread.framework.service;

import com.newthread.framework.db.FarmerDB;
import com.newthread.framework.db.Farmer_Product;
import com.newthread.framework.db.ReportDB;
import com.newthread.framework.entity.Farm;
import com.newthread.framework.entity.Farmer;
import com.newthread.framework.entity.Products;
import com.newthread.framework.util.StringUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class FarmersServiceImpl implements FarmersService {

    private Map<Integer, Farmer> map = FarmerDB.map;

    @Override
    public int createFarm(Farmer farmer) {

        if (farmer != null) {
            farmer.setFid(map.size());
            map.put(farmer.getFid(), farmer);
            return farmer.getFid();
        }
        return 0;
    }

    @Override
    public Farmer update(Farmer farmer) {

        Farmer f = map.get(farmer.getFid());

        if (f == null) {
            return f;
        }

        f = farmer;
        return f;
    }

    @Override
    public Farmer getFarmer(Integer fid) {
        return map.get(fid);
    }

    @Override
    public List<Products> getProducts(Integer fid) {

        Farmer f = getFarmer(fid);

        return Farmer_Product.get(f);
    }

    @Override
    public String addProduces(Integer fid, Products p) {

        Farmer farmer = getFarmer(fid);

        if (farmer == null) {
            return null;
        }
        p.setFspid(StringUtil.randomInteger() + "");
        Farmer_Product.put(farmer, p);

        return p.getFspid();
    }

    @Override
    public String updateParticalProducts(Integer fid, Products p) {

        Farmer farmer = getFarmer(fid);

        if (farmer == null || p == null) {
            return null;
        }

        List<Products> list = Farmer_Product.get(farmer);
        boolean b = false;
        if (list.contains(p)) {

            for (Products products : list) {
                //compare value and update
                if (products.getFspid().equals(p.getFspid())) {

                    b = true;

                    if (p.getGcpid() != null) {
                        products.setGcpid(p.getGcpid());
                    }
                    if (p.getEnd_date() != null) {
                        products.setEnd_date(p.getEnd_date());
                    }
                    if (p.getName() != null) {
                        products.setName(p.getName());
                    }
                    if (p.getNote() != null) {
                        products.setNote(p.getNote());
                    }
                    if (p.getStart_date() != null) {
                        products.setStart_date(p.getStart_date());
                    }
                    if (p.getPrice() != 0) {
                        products.setPrice(p.getPrice());
                    }
                    if (p.getProduct_unit() != null) {
                        products.setProduct_unit(p.getProduct_unit());
                    }
                    if (p.getImage() != null) {
                        products.setImage(p.getImage());
                    }
                    p = products;
                }
            }
        }
        return b ? p.getFspid() : null;
    }

    @Override
    public Products getProductsByFsid(Integer fid, String fspid) {

        Farmer farmer = getFarmer(fid);

        if (farmer == null || fspid == null) {
            return null;
        }

        List<Products> list = Farmer_Product.get(farmer);

        for (Products products : list) {
            if (products.getFspid().equals(products.getFspid())) {
                return products;
            }
        }
        return null;
    }

    @Override
    public List<Farmer> search(String key) {

        return FarmerDB.getAllFarmer();


    }
}
