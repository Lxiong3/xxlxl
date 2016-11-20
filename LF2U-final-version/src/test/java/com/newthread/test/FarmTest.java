package com.newthread.test;

import com.newthread.domain.Farm;
import com.newthread.exception.NoSuchCatalogException;
import com.newthread.model.ZipObj;
import com.newthread.service.FarmersService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/spring-core.xml")
public class FarmTest {

    private final Logger logger = Logger.getLogger(this.getClass());


    @Resource
    private FarmersService farmersService;

    @Rollback
    @Test
    public void addProduces() throws NoSuchCatalogException {

        Farm farm = new Farm();
        farm.setName("new Farm");
        farm.setWeb("google.com");
        farm.setAddress("China");
        farm.setPhone("123");
        farm.setFid("701");
        farmersService.createFarm(farm);

    }

    @Test
    public void get() throws NoSuchCatalogException {


        List<ZipObj> list = farmersService.getAllFarmerInfoByZip(12312);

        if(list == null){
            logger.info("null point ---------------->");
            return;
        }


        logger.info("size : " + list.size());

    }

    @Test
    public void gets() {

        farmersService.getProducts("1");
    }

}
