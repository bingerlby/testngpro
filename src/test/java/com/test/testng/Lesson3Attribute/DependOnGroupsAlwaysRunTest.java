/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package com.test.testng.Lesson3Attribute;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

/**
 * dependOnGroupsAlwaysRun
 *
 * @author binger
 * @created 2018/9/3
 */
public class DependOnGroupsAlwaysRunTest {
    @Test(groups = "test1")
    public void test1() throws Exception {
        System.out.println("AlwaysRunTest-test1");
        throw new Exception("莫名失败！-test1");
    }

    @Test(groups = "test2")
    public void test2() throws Exception {
        System.out.println("AlwaysRunTest-test2");
        throw new Exception("莫名失败！-test2");
    }

    //虽然@Test失败，但依然可以运行
    @Test(dependsOnGroups = {"test1", "test2"}, alwaysRun = true)
    public void test3() {
        System.out.println("DependOnGroupsAlwaysRun-test3-alwaysRun");
    }
}
