package com.newthread.mock;

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
public class FarmerControllerTest {

    private MockMvc mockMvc;

    @Resource
    private WebApplicationContext webApplicationContext;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void createAccount() throws Exception {

        MvcResult mvcResult = mockMvc.perform
                (
                        MockMvcRequestBuilders.post("/farmers")
                                .contentType(MediaType.APPLICATION_JSON_UTF8)
                )
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        Assert.assertNotNull(mvcResult);
    }

    @Test
    public void updateAccount() throws Exception {
        MvcResult mvcResult = mockMvc.perform
                (
                        MockMvcRequestBuilders.put("/farmers/1")
                                .contentType(MediaType.APPLICATION_JSON_UTF8)
                )
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        Assert.assertNotNull(mvcResult);
    }

    @Test
    public void getAccount() {
        MvcResult mvcResult = null;
        try {
            mvcResult = mockMvc.perform
                    (
                            MockMvcRequestBuilders.get("/farmers/1")
                                    .contentType(MediaType.APPLICATION_JSON_UTF8)
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andReturn();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void getAccountZip() {
        try {
            MvcResult mvcResult = mockMvc.perform
                    (
                            MockMvcRequestBuilders.get("/farmers/1")
                                    .contentType(MediaType.APPLICATION_JSON_UTF8)
                            .param("zip","123")
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andReturn();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void getAccountProducts(){
        MvcResult mvcResult = null;
        try {
            mvcResult = mockMvc.perform
                    (
                            MockMvcRequestBuilders.get("/farmers/1/products")
                                    .contentType(MediaType.APPLICATION_JSON_UTF8)
                                    .param("zip","123")
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andReturn();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void addAccountProducts() {
        MvcResult mvcResult = null;
        try {
            mvcResult = mockMvc.perform
                    (
                            MockMvcRequestBuilders.post("/farmers/1/products")
                                    .contentType(MediaType.APPLICATION_JSON_UTF8)
                                    .param("zip","123")
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andReturn();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Assert.assertNotNull(mvcResult);
    }

    @Test
    public void updateAccountProducts() {
        MvcResult mvcResult = null;
        try {
            mvcResult = mockMvc.perform
                    (
                            MockMvcRequestBuilders.post("/farmers/1/products/1")
                                    .contentType(MediaType.APPLICATION_JSON_UTF8)
                                    .param("zip","123")
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andReturn();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void getAccountProducts1() {
        try {
            MvcResult mvcResult = mockMvc.perform
                    (
                            MockMvcRequestBuilders.get("/farmers/1/products/1")
                                    .contentType(MediaType.APPLICATION_JSON_UTF8)
                                    .param("zip","123")
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andReturn();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}