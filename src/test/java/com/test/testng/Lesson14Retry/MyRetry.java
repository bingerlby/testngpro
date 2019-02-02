/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package com.test.testng.Lesson14Retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * 在这里编写类的功能描述
 *
 * @author binger
 * @created 2018/9/10
 */
public class MyRetry implements IRetryAnalyzer {
    public int retryCount = 1;
    private int maxRetryCount = 3;
    /**
     * Returns true if the test method has to be retried, false otherwise.
     *
     * @param result The result of the test method that just ran.
     * @return true if the test method has to be retried, false otherwise.
     */
    public boolean retry(ITestResult result) {
        if (retryCount++ < maxRetryCount) {
            return true;
        }
        return false;
    }
}
