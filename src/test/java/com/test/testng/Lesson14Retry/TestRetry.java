/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package com.test.testng.Lesson14Retry;

import org.testng.IRetryAnalyzer;
import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

/**
 * 在这里编写类的功能描述
 *
 * @author binger
 * @created 2018/9/10
 */
public class TestRetry {
    private int flag = 1;
    @Test
    public void test() throws InterruptedException{
        System.out.println("retry");
        flag++;
        Thread.sleep(200);
        assertThat("TestRetry", comparesEqualTo("testRetry"));
    }

    @Test
    public void test2() throws InterruptedException {
        System.out.println("retry2");
        if (flag == 5) {
            flag++;
            assertThat("testRetry", comparesEqualTo("testRetry"));
        } else {
            flag++;
            assertThat("TestRetry", comparesEqualTo("testRetry"));
        }
    }
}
