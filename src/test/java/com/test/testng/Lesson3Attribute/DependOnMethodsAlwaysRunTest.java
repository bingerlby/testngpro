/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package com.test.testng.Lesson3Attribute;

import org.testng.annotations.Test;

/**
 * dependOnMethods
 *
 * @author binger
 * @created 2018/9/3
 */
public class DependOnMethodsAlwaysRunTest {
    @Test
    public void test1() throws Exception {
        System.out.println("AlwaysRunTest2-test1");
        throw new Exception("莫名失败！");
    }

    //虽然@Test失败，但依然可以运行
    @Test(dependsOnMethods = {"test1"}, alwaysRun = true)
    public void test2() {
        System.out.println("AlwaysRunTest2-test2-alwaysRun");
    }
}
