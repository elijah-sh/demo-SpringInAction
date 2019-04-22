package com.web.spittr;

import com.web.spittr.controller.HomeController;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class HomeControllerTest {

    @Test
    public void shouldShowRecentSpittles() throws Exception {
        List<Spittle> expectedSpittles = createSpittleList(20);
       /* SpittleRepository mockRepository = mock(SpittleRepository.class);
        when(mockRepository.findSpittles(Long.MAX_VALUE, 20))
                .thenReturn(expectedSpittles);*/

    }

    private List<Spittle> createSpittleList (int count) {
        List<Spittle> spittles = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            spittles.add(new Spittle("Spittle " + i, new Date()));
        }
        return spittles;
    }

    @Test
    public void testHomePage() throws Exception {
        HomeController homeController = new HomeController();
        // 搭建MockMvc
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(homeController).build();
        // 对 "/" 执行GET请求   预期得到home视图
        mockMvc.perform(get("/")).andExpect(view().name("home"));
       // assertEquals("home", in.home());
    }

    @Test
    public void test() throws Exception {
        BigDecimal amount = BigDecimal.valueOf(-11.00);
        System.out.println(amount.compareTo(BigDecimal.ZERO) == -1);
        System.out.println((amount != null && amount.compareTo(BigDecimal.ZERO) <= 0));
        if (amount == null
                || (amount != null
                && amount.compareTo(BigDecimal.ZERO) == -1)) {

            System.out.println(amount);
        }
    }

    @Test
    public void registerTest() throws Exception {

    }
}