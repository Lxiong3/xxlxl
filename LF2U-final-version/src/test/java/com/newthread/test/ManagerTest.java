package com.newthread.test;

import com.newthread.service.ManagerService;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/spring-core.xml")
public class ManagerTest {

    private static final Logger logger = Logger.getLogger(ManagerTest.class);

    @Resource
    private ManagerService managerService;

    @Before
    public void init() {
        logger.info("start...............");
    }

    @After
    public void after() {
        logger.info("After...............");
    }

    @Test
    @Transactional
    public void gssssetss() {
        managerService.getAllManager();
    }

    @Test
    public void getss() {
        managerService.createFarm();
    }

    @Rollback
    @Test
    public void testcreate() {
        managerService.addCatalog("mmmm");
    }

}
