package com.newthread.mock;

import com.newthread.model.RegisterModel;
import com.newthread.util.StringUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;

@WebAppConfiguration(value = "src/main/webapp")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextHierarchy({
        @ContextConfiguration(name = "parent", locations = "classpath:spring/spring-core.xml"),
        @ContextConfiguration(name = "child", locations = "classpath:spring/spring-mvc.xml")
})
public class CustomerscontrollerTest {

    private MockMvc mockMvc;

    @Resource
    private WebApplicationContext webApplicationContext;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void get() throws Exception {

        MvcResult mvcResult = mockMvc.perform
                (
                        MockMvcRequestBuilders.get("/customers/1")
                                .contentType(MediaType.APPLICATION_JSON_UTF8)
                )
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        Assert.assertNotNull(mvcResult);

    }

    @Test
    public void create() throws Exception {

        RegisterModel model = new RegisterModel();
        model.setPhone("123");
        model.setZip("123123123");
        model.setName("Jack");
        model.setStreet("Alison street");
        model.setEmail("yyyy@gmail.com");

        MvcResult mvcResult = mockMvc.perform
                (
                        MockMvcRequestBuilders.post("/customers")
                                .contentType(MediaType.APPLICATION_JSON_UTF8)
                                .content(StringUtil.obj2json(model))
                )
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        Assert.assertNotNull(mvcResult);
    }

    @Test
    public void put() throws Exception {

        RegisterModel model = new RegisterModel();
        model.setPhone("123");
        model.setZip("123123123");
        model.setName("Jack");
        model.setStreet("Alison street");
        model.setEmail("yyyy@gmail.com");

        MvcResult mvcResult = mockMvc.perform
                (
                        MockMvcRequestBuilders.put("/customers/1")
                                .contentType(MediaType.APPLICATION_JSON_UTF8)
                                .content(StringUtil.obj2json(model))
                )
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        Assert.assertNotNull(mvcResult);
    }
    @Test
    public void createOrder() throws Exception {
        MvcResult mvcResult = mockMvc.perform
                (
                        MockMvcRequestBuilders.post("/customers/1/orders")
                                .contentType(MediaType.APPLICATION_JSON_UTF8)
                )
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        Assert.assertNotNull(mvcResult);
    }

    @Test
    public void getOrder() {
        try {
            MvcResult mvcResult = mockMvc.perform
                    (
                            MockMvcRequestBuilders.get("/customers/1/orders")
                                    .contentType(MediaType.APPLICATION_JSON_UTF8)
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andReturn();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void ggggg() {
        MvcResult mvcResult = null;
        try {
            mvcResult = mockMvc.perform
                    (
                            MockMvcRequestBuilders.get("/customers/1/orders/1")
                                    .contentType(MediaType.APPLICATION_JSON_UTF8)
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andReturn();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void updateOrders() throws Exception {
        MvcResult mvcResult = mockMvc.perform
                (
                        MockMvcRequestBuilders.post("/customers/1/orders/1")
                                .contentType(MediaType.APPLICATION_JSON_UTF8)
                )
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        Assert.assertNotNull(mvcResult);
    }

}