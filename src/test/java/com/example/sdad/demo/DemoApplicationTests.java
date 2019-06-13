package com.example.sdad.demo;

import com.example.sdad.demo.bean.User;
import com.example.sdad.demo.services.UserServices;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private UserServices userServices;
    @Test
    public void contextLoads() throws Exception {

    }

}
