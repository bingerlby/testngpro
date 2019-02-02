/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package com.test.testng.Lesson15AsyncTask;

import org.testng.annotations.Test;

/**
 * 指定invocationCount
 *
 * @author binger
 * @created 2018/9/10
 */
public class InvocationCount {
    @Test
    public void addOrder() {
        System.out.println("Add Order");
    }

    //可以设置经验值，但不能避免误报
    @Test(dependsOnMethods = "addOrder",invocationCount = 5)
    public void getOrderStatus() throws InterruptedException{
        Thread.sleep(1000);
    }
}
