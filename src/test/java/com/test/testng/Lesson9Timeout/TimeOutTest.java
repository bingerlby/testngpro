/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package com.test.testng.Lesson9Timeout;

import com.test.testng.FutureSolution;
import com.test.testng.LoopSolution;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * 在这里编写类的功能描述
 *
 * @author binger
 * @created 2018/9/7
 */
public class TimeOutTest {
    @Test(timeOut = 5000)
    public void testTimeOut() {
        LoopSolution.deadLoop();
    }

    @Test(invocationCount = 3, invocationTimeOut = 1000)
    public void testInvocation() {
        System.out.println("deadLoop");
        LoopSolution.sleepLoop();
    }

    @Test(timeOut = 10000, invocationCount = 10)
    public void testFutureTask() {
        FutureSolution.getInt();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertThat(FutureSolution.IntegerNum, equalTo(5));
    }


}
