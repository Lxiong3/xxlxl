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
public class ManagersControllerTest {

    private MockMvc mockMvc;

    @Resource
    private WebApplicationContext webApplicationContext;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void catalog() throws Exception {
        MvcResult mvcResult = mockMvc.perform
                (
                        MockMvcRequestBuilders.get("/managers/catalog")
                                .contentType(MediaType.APPLICATION_JSON_UTF8)
                )
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        Assert.assertNotNull(mvcResult);
    }

    @Test
    public void o() throws Exception {
        MvcResult mvcResult = mockMvc.perform
                (
                        MockMvcRequestBuilders.get("/managers/accounts")
                                .contentType(MediaType.APPLICATION_JSON_UTF8)
                )
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        Assert.assertNotNull(mvcResult);
    }

    @Test
    public void ddd() {
        MvcResult mvcResult = null;
        try {
            mvcResult = mockMvc.perform
                    (
                            MockMvcRequestBuilders.get("/managers/accounts/1")
                                    .contentType(MediaType.APPLICATION_JSON_UTF8)
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andReturn();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Assert.assertNotNull(mvcResult);
    }

    @Test
    public void dddasdf() {
        MvcResult mvcResult = null;
        try {
            mvcResult = mockMvc.perform
                    (
                            MockMvcRequestBuilders.get("/managers/accounts/1111")
                                    .contentType(MediaType.APPLICATION_JSON_UTF8)
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andReturn();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void report() throws Exception {
        MvcResult mvcResult = mockMvc.perform
                (
                        MockMvcRequestBuilders.get("/managers/reports")
                                .contentType(MediaType.APPLICATION_JSON_UTF8)
                )
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        Assert.assertNotNull(mvcResult);
    }

    @Test
    public void report1() throws Exception {
        MvcResult mvcResult = mockMvc.perform
                (
                        MockMvcRequestBuilders.get("/managers/reports/1")
                                .contentType(MediaType.APPLICATION_JSON_UTF8)
                )
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        Assert.assertNotNull(mvcResult);
    }

    @Test
    public void search() throws Exception {
        MvcResult mvcResult = mockMvc.perform
                (
                        MockMvcRequestBuilders.get("/search")
                                .contentType(MediaType.APPLICATION_JSON_UTF8)
                )
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        Assert.assertNotNull(mvcResult);
    }

    @Test
    public void delivery() throws Exception {
        MvcResult mvcResult = mockMvc.perform
                (
                        MockMvcRequestBuilders.get("/delivery/1")
                                .contentType(MediaType.APPLICATION_JSON_UTF8)
                )
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        Assert.assertNotNull(mvcResult);
    }

    @Test
    public void gggg() throws Exception {
        MvcResult mvcResult = mockMvc.perform
                (
                        MockMvcRequestBuilders.get("/gggggg")
                                .contentType(MediaType.APPLICATION_JSON_UTF8)
                )
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        Assert.assertNotNull(mvcResult);
    }
}