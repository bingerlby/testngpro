/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package com.test.testng.Lesson6Depend;

import org.testng.annotations.Test;

/**
 * 在这里编写类的功能描述
 *
 * @author binger
 * @created 2018/9/7
 */
public class DependTest {
    @Test
    public void getList() {
        System.out.println("getList");
    }

    @Test(dependsOnMethods = "getList")
    public void getSeatList() {
        System.out.println("getSeatList");
    }

    @Test(dependsOnMethods = "getSeatList")
    public void addOrder() {
        System.out.println("addOrder");
    }

    @Test(dependsOnMethods = "addOrder")
    public void pay() {
        System.out.println("pay");
    }

}
