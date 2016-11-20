package com.newthread.test;

import com.newthread.domain.Farmer;
import com.newthread.domain.Product;
import com.newthread.exception.NoSuchCatalogException;
import com.newthread.service.FarmersService;
import com.newthread.util.StringUtil;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/spring-core.xml")
public class FarmerTest {

    private final Logger logger = Logger.getLogger(this.getClass());


    @Resource
    private FarmersService farmersService;

    @Rollback
    @Test
    public void addProduces() throws NoSuchCatalogException {

        Product p = new Product();
        p.setEndDate(323233);
        p.setGcpid("1");
        p.setName("APPLE");

        farmersService.addProduces("1", p);

    }

    @Test
    public void createFarm() {

        Farmer farmer = new Farmer();
        farmer.setFid(StringUtil.randomString());
        farmersService.createFarm(farmer);
    }

    @Test
    public void update() {
        Farmer farmer = farmersService.getFarmer(StringUtil.randomString());
        if (farmer == null) {
            logger.info("null -----------------");
            return;
        }
        farmer.setFid(StringUtil.randomString());
        if (farmer != null) {
            farmersService.update(farmer);
        }
    }


    @Test
    public void getProducts() {

        Farmer farmer = farmersService.getFarmer("d");

        if (farmer == null) {
            return;
        }

        System.out.println(farmersService.getProducts(farmer.getFid()).get(0));
    }


}
