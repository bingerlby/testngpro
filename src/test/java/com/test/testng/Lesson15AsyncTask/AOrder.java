/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package com.test.testng.Lesson15AsyncTask;

/**
 * 在这里编写类的功能描述
 *
 * @author binger
 * @created 2018/9/10
 */
public class AOrder {
    private static long startTime;
    static {
        startTime = System.currentTimeMillis();
    }
    public static int getOrderStatus() {
        if (System.currentTimeMillis() - startTime >= 5000) {
            return 5;
        }
        return 0;
    }
}
