/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package com.test.testng.Lesson3Attribute;

import com.test.testng.Lesson2DataProvider.ExcelDataProviderTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * alwaysRun
 *
 * @author binger
 * @created 2018/9/3
 */
public class AlwaysRunTest {
    @Test
    public void test1() throws Exception{
        System.out.println("AlwaysRunTest-test1");
        throw new Exception("莫名失败！");
    }

    //虽然@Test失败，但依然可以运行
    @AfterClass(alwaysRun = true)
    public void afterClass() {
        System.out.println("AlwaysRunTest-afterClass-alwaysRun");
    }
}
