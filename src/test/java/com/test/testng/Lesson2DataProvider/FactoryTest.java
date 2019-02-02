/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package com.test.testng.Lesson2DataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

/**
 * 在这里编写类的功能描述
 *
 * @author binger
 * @created 2018/9/3
 */
public class FactoryTest {
    private int param;

    @Factory(dataProvider = "dataMethod")
    public FactoryTest(int param) {
        this.param = param;
    }

    @DataProvider
    public static Object[][] dataMethod() {
        return new Object[][] { new Object[]{ 10 }, new Object[]{ 20 } ,new Object[]{ 30 }};
    }

    @Test
    public void testMethodOne() {
        int opValue = param + 1;
        System.out.println("Test method one output: " + opValue);
    }

    @Test
    public void testMethodTwo() {
        int opValue = param + 2;
        System.out.println("Test method two output: " + opValue);
    }
}
