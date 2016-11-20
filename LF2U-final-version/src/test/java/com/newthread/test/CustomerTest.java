package com.newthread.test;

import com.newthread.domain.Customer;
import com.newthread.domain.Orders;
import com.newthread.model.OrderResponse;
import com.newthread.model.RegisterModel;
import com.newthread.service.CustomersService;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/spring-core.xml")
public class CustomerTest {

    private static final Logger logger = Logger.getLogger(CustomerTest.class);

    @Resource
    private CustomersService customersService;

    @Before
    public void init() {
        logger.info("start...............");
    }

    @After
    public void after() {
        logger.info("After...............");
    }

    @Test
    public void gssssetss() {
        List<OrderResponse> customer = customersService.getOrder("1");
        logger.info("is null : " + (customer == null));
    }

    @Test
    public void getss() {
        Orders customer = customersService.getDetailOrder("1", "dd");
        logger.info("is null : " + (customer == null));
    }

    @Test
    public void get() {
        Customer customer = customersService.get("1");
        logger.info("is null : " + (customer == null));
    }

    @Rollback
    @Test
    public void testcreate() {
        RegisterModel registerModel = new RegisterModel();
        registerModel.setName("tom");
        registerModel.setPhone("12222222222");
        registerModel.setZip("1110");
        String id = customersService.create(registerModel);

        logger.info("result : " + id);
    }

}
