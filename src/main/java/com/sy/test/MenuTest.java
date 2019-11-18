package com.sy.test;

import com.sy.config.SpringConfig;
import com.sy.service.common.MenuService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest(classes = SpringConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class MenuTest {

    @Autowired
    private MenuService service;

    @Test
    public void test1() throws Exception{
        String json = service.makeMenus(1);
    }
}
