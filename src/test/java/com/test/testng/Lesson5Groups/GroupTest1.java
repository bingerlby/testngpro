/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package com.test.testng.Lesson5Groups;

import org.testng.annotations.*;

/**
 * 在这里编写类的功能描述
 *
 * @author binger
 * @created 2018/9/6
 */


public class GroupTest1 {
    @BeforeTest(groups = "group2")
    public void beforeTest() {
        System.out.println("testGroup1-groups2-beforeTest");
    }

    @BeforeMethod(groups = "group1")
    public void beforeMethod1() {
        System.out.println("testGroup1-groups1-beforeMethod1");
    }

    @BeforeMethod(groups = "group2")
    public void beforeMethod2() {
        System.out.println("testGroup1-groups2-beforeMethod2");
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod3() {
        System.out.println("testGroup1-alwaysRun-beforeMethod3");
    }

    @BeforeGroups("group1")
    public void beforeGroups1() {
        System.out.println("testGroup1-groups1-beforeGroup");
    }

    @BeforeGroups("group2")
    public void beforeGroups2() {
        System.out.println("testGroup1-groups2-beforeGroup2");
    }

    @Test(groups = "group1")
    public void testGroup11() {
        System.out.println("testGroup11");
    }

    @Test(groups = {"group1", "group2"})
    public void testGroup12() {
        System.out.println("testGroup12");
    }
}
