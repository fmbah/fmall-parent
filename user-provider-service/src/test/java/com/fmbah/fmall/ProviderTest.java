package com.fmbah.fmall;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class ProviderTest {


    @Test
    public void test0() throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("provider.xml");
        context.start();

        System.in.read();
    }

}
