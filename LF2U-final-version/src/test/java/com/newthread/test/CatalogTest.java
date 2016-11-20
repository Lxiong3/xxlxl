package com.newthread.test;

import com.newthread.exception.NoSuchCatalogException;
import com.newthread.service.CatalogService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/spring-core.xml")
public class CatalogTest {

    private final Logger logger = Logger.getLogger(this.getClass());


    @Resource
    private CatalogService catalogService;

    @Test
    public void addProduces() throws NoSuchCatalogException {

        catalogService.getAllCatalog();

    }

}
