package com.newthread.service;

import com.newthread.domain.DeliversTo;
import com.newthread.mapper.*;
import com.newthread.model.FarmerRegisterModel;
import com.newthread.util.StringUtil;
import com.newthread.domain.Farm;
import com.newthread.domain.Farmer;
import com.newthread.domain.Product;
import com.newthread.exception.NoSuchCatalogException;
import com.newthread.model.ZipObj;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@Service
public class FarmersServiceImpl implements FarmersService {

    private final Logger logger = Logger.getLogger(this.getClass());

    @Resource
    private ProductMapper productMapper;
    @Resource
    private FarmerMapper farmerMapper;
    @Resource
    private FarmMapper farmMapper;
    @Resource
    private DeliversToMapper deliversToMapper;
    @Resource
    private CatalogMapper catalogMapper;

    @Override
    public String createFarm(Farm farm) {
        farm.setFaid(StringUtil.randomString());
        farmMapper.insert(farm);
        return farm.getFid();
    }
    @Override
    public String createFarm(Farmer farmer) {
        farmer.setFid(StringUtil.randomInteger() + "");
        farmerMapper.insert(farmer);
        return farmer.getFid();
    }

    @Override
    public Farmer update(Farmer farmer) {

        Farmer f = farmerMapper.selectByPrimaryKey(farmer.getFid());

        if (f == null) {
            return null;
        }

        farmerMapper.updateByPrimaryKey(farmer);

        return farmer;
    }

    @Override
    public Farmer getFarmer(String fid) {
        return farmerMapper.selectByPrimaryKey(fid);
    }

    @Override
    public List<Product> getProducts(String fid) {
        return productMapper.selectAll();
    }

    @Override
    public String addProduces(String fid, Product p) throws NoSuchCatalogException {

        if (catalogMapper.selectByPrimaryKey(p.getGcpid()) == null) {
            throw new NoSuchCatalogException();
        }
        p.setFspid(StringUtil.randomString());

        //Farmer_Product.put(farmer, p);

        productMapper.insert(p);

        return p.getFspid();
    }

    @Override
    public String updateParticalProducts(String fid, Product p) {

        if(fid == null || p == null){
            return null;
        }


        Farmer farmer = farmerMapper.selectByPrimaryKey(fid);
        Product product = productMapper.selectByPrimaryKey(p.getFspid());
        if (farmer == null || product == null) {
            return null;
        }

        //compare value and update
        if (product.getFspid().equals(p.getFspid())) {

            if (p.getGcpid() != null) {
                product.setGcpid(p.getGcpid());
            }
            if (p.getEndDate() != null) {
                product.setEndDate(p.getEndDate());
            }
            if (p.getName() != null) {
                product.setName(p.getName());
            }
            if (p.getNote() != null) {
                product.setNote(p.getNote());
            }
            if (p.getStartDate() != null) {
                product.setStartDate(p.getStartDate());
            }
            if (p.getPrice() != 0) {
                product.setPrice(p.getPrice());
            }
            if (p.getProductUnit() != null) {
                product.setProductUnit(p.getProductUnit());
            }
            if (p.getImage() != null) {
                product.setImage(p.getImage());
            }
            productMapper.updateByPrimaryKey(product);
        }
        return p.getFspid();
    }

    @Override
    public Product getProductsByFsid(String fid, String fspid) {
        return productMapper.selectByPrimaryKey(fspid);
    }

    @Override
    public List<Farmer> search(String key) {

        return null;


    }

    @Transactional
    public String createFarm(FarmerRegisterModel f) {

        if (f == null) {
            return null;
        }

        //farmer
        FarmerRegisterModel.PersonalInfoBean personalInfoBean = f.getPersonal_info();
        Farmer farmer = new Farmer();
        farmer.setFid(StringUtil.randomInteger() + "");
        farmer.setName(personalInfoBean.getName());
        farmer.setEmail(personalInfoBean.getEmail());
        farmer.setPhone(personalInfoBean.getPhone());
        farmerMapper.insert(farmer);

        //farm
        FarmerRegisterModel.FarmInfoBean farmInfoBean = f.getFarm_info();
        Farm farm = new Farm();
        farm.setFid(farmer.getFid());
        farm.setPhone(farmInfoBean.getPhone());
        farm.setAddress(farmInfoBean.getAddress());
        farm.setWeb(farmInfoBean.getWeb());
        farm.setFaid(StringUtil.randomString());
        farm.setName(farmInfoBean.getName());
        farmMapper.insert(farm);

        // delivery_to
        DeliversTo deliversTo = null;
        for (String str : f.getDelivers_to()) {
            deliversTo = new DeliversTo();
            deliversTo.setUid(farmer.getFid());
            deliversTo.setZip(str);
            deliversTo.setDelivery_to_id(StringUtil.randomString());
            deliversToMapper.insert(deliversTo);

        }

        return farmer.getFid();
    }

    @Override
    public List<ZipObj> getAllFarmerInfoByZip(Integer zip) {

        List<String> list = deliversToMapper.selectUidByZip(zip);
        String name = deliversToMapper.selectNameByByZip(zip);
        if (list == null || list.size() == 0) {
            return null;
        }


        List<ZipObj> l = new ArrayList<>();
        ZipObj obj = null;
        Farmer farmer = null;
        for (String key : list) {
            farmer = farmerMapper.selectByPrimaryKey(key);
            if (farmer != null) {
                obj = new ZipObj();
                obj.setFid(farmer.getFid());
            }
            obj.setName(name);
            l.add(obj);
        }

        return l;
    }

    @Transactional
    @Override
    public String update(String fid, FarmerRegisterModel f) {

        //farmer
        FarmerRegisterModel.PersonalInfoBean personalInfoBean = f.getPersonal_info();
        Farmer farmer = farmerMapper.selectByPrimaryKey(fid);
        if (farmer == null) {
            return null;
        }
        farmer.setName(personalInfoBean.getName());
        farmer.setEmail(personalInfoBean.getEmail());
        farmer.setPhone(personalInfoBean.getPhone());
        farmerMapper.updateByPrimaryKey(farmer);

        //farm
        FarmerRegisterModel.FarmInfoBean farmInfoBean = f.getFarm_info();
        List<Farm> list = farmMapper.selectAllByFid(fid);
        if (list != null) {
            for (Farm farm : list) {
                farm.setPhone(farmInfoBean.getPhone());
                farm.setAddress(farmInfoBean.getAddress());
                farm.setWeb(farmInfoBean.getWeb());
                farm.setName(farmInfoBean.getName());
                farmMapper.updateByPrimaryKey(farm);
            }
        }

        //delete all
        deliversToMapper.deleteAllByFid(fid);

        // delivery_to
        DeliversTo deliversTo = null;
        for (String str : f.getDelivers_to()) {
            deliversTo = new DeliversTo();
            deliversTo.setUid(farmer.getFid());
            deliversTo.setZip(str);
            deliversTo.setDelivery_to_id(StringUtil.randomString());
            deliversToMapper.insert(deliversTo);

        }

        return farmer.getFid();
    }

    @Override
    public FarmerRegisterModel getFarmerInfo(String fid) {


        Farmer farmer = farmerMapper.selectByPrimaryKey(fid);

        if (farmer == null) {
            return null;
        }

        FarmerRegisterModel model = new FarmerRegisterModel();
        FarmerRegisterModel.PersonalInfoBean infoBean = new FarmerRegisterModel.PersonalInfoBean();
        infoBean.setName(farmer.getName());
        infoBean.setEmail(farmer.getEmail());
        infoBean.setPhone(farmer.getPhone());
        model.setPersonal_info(infoBean);

        //farm
        List<Farm> list = farmMapper.selectAllByFid(fid);
        if (list != null) {
            FarmerRegisterModel.FarmInfoBean farmInfoBean = new FarmerRegisterModel.FarmInfoBean();
            for (Farm farm : list) {
                farmInfoBean.setPhone(farm.getPhone());
                farmInfoBean.setAddress(farm.getAddress());
                farmInfoBean.setWeb(farm.getWeb());
                farmInfoBean.setName(farm.getName());
                // a farmer should has 1~n farm  but ..........
                model.setFarm_info(farmInfoBean);
            }
        }

        // delivery_to
        DeliversTo deliversTo = null;
        List<String> strings = deliversToMapper.selectZipByUid(fid);
        model.setDelivers_to(strings);

        return model;
    }
}
