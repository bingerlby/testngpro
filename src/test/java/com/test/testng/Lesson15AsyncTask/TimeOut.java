/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package com.test.testng.Lesson15AsyncTask;

import org.testng.annotations.Test;

/**
 * 通过指定timeout
 *
 * @author binger
 * @created 2018/9/10
 */
public class TimeOut {
    @Test
    public void addOrder() {
        System.out.println("Add Order");
    }
    //设置timeout为系统间调用的超时值，或经验值(用户忍耐度)，可以加入重试
    @Test(dependsOnMethods = "addOrder",timeOut = 60000)
    public void getOrderStatus() throws InterruptedException{
        int orderStatus = 0;
        while (orderStatus != 5) {
            //调用 获取订单状态 方法
            orderStatus = AOrder.getOrderStatus();
            System.out.println("orderStatus=" + orderStatus);
            Thread.sleep(1000);
        }
    }
}
