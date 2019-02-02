/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package com.test.testng;

/**
 * 在这里编写类的功能描述
 *
 * @author binger
 * @created 2018/9/7
 */
public class LoopSolution {
    public static Integer deadLoop() {
        while (true){
        }
    }

    public static void sleepLoop() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
