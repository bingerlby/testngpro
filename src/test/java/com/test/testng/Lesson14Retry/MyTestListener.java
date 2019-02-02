/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package com.test.testng.Lesson14Retry;

import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.util.Iterator;
import java.util.Set;

/**
 * 只适用于单线程且未设置invocationCount
 *
 * @author binger
 * @created 2018/9/10
 */
public class MyTestListener extends TestListenerAdapter {
    private long getLastStartTime(ITestNGMethod method, Set<ITestResult> resultSet) {
        long lastStartTime = 0;
        Iterator<ITestResult> iterator = resultSet.iterator();
        while (iterator.hasNext()) {
            ITestResult tmpTestResult = iterator.next();
            ITestNGMethod tmpMethod = tmpTestResult.getMethod();
            if (tmpMethod.getMethodName().equals(method.getMethodName())) {
                if (tmpTestResult.getStartMillis() > lastStartTime) {
                    lastStartTime = tmpTestResult.getStartMillis();
                }
            }
        }
        return lastStartTime;
    }

    private void removeTestResult(ITestResult testResult, Iterator<ITestResult> testResultIterator) {
        ITestNGMethod method = testResult.getMethod();
        while (testResultIterator.hasNext()) {
            ITestResult tmp = testResultIterator.next();
            if (tmp.getMethod().getMethodName().equals(method.getMethodName())) {
                testResultIterator.remove();
            }
        }
    }

    @Override
    public void onFinish(ITestContext testContext) {
        super.onFinish(testContext);

        //只保留最后一次结果
        Iterator<ITestResult> listOfFailTests = testContext.getFailedTests().getAllResults().iterator();

        while (listOfFailTests.hasNext()) {
            Iterator<ITestResult> listOfPassTests = testContext.getPassedTests().getAllResults().iterator();
            Iterator<ITestResult> listOfSkipTests = testContext.getSkippedTests().getAllResults().iterator();

            ITestResult failedTest = listOfFailTests.next();
            ITestNGMethod method = failedTest.getMethod();
            long passTestLastStartTime = getLastStartTime(method, testContext.getPassedTests().getAllResults());
            long skipTestLastStartTime = getLastStartTime(method, testContext.getSkippedTests().getAllResults());
            long failTestLastStartTime = getLastStartTime(method, testContext.getFailedTests().getAllResults());

            if (passTestLastStartTime > skipTestLastStartTime) {
                if (passTestLastStartTime >= failTestLastStartTime) {//pass
                    listOfFailTests.remove();
                    removeTestResult(failedTest, listOfSkipTests);
                    removeTestResult(failedTest, listOfFailTests);
                } else {//fail
                    removeTestResult(failedTest, listOfSkipTests);
                    removeTestResult(failedTest, listOfPassTests);
                }
            } else {
                if (skipTestLastStartTime > failTestLastStartTime) {//skip
                    listOfFailTests.remove();
                    removeTestResult(failedTest, listOfFailTests);
                    removeTestResult(failedTest, listOfPassTests);
                } else {//fail
                    removeTestResult(failedTest, listOfSkipTests);
                    removeTestResult(failedTest, listOfPassTests);
                }
            }
        }

        Iterator<ITestResult> listOfSkipTests = testContext.getSkippedTests().getAllResults().iterator();

        while (listOfSkipTests.hasNext()) {
            Iterator<ITestResult> listOfPassTests = testContext.getPassedTests().getAllResults().iterator();

            ITestResult skipTest = listOfSkipTests.next();
            ITestNGMethod method = skipTest.getMethod();
            long passTestLastStartTime = getLastStartTime(method, testContext.getPassedTests().getAllResults());
            long skipTestLastStartTime = getLastStartTime(method, testContext.getSkippedTests().getAllResults());

            if (passTestLastStartTime >= skipTestLastStartTime) {
                listOfSkipTests.remove();
                removeTestResult(skipTest, listOfSkipTests);
            } else {
                removeTestResult(skipTest, listOfPassTests);
            }
        }
    }
}
