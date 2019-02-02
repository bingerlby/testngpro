/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package com.test.testng.Lesson13TestListeners;

import org.testng.Reporter;
import org.testng.annotations.Test;

/**
 * 在这里编写类的功能描述
 *
 * @author binger
 * @created 2018/9/10
 */
public class TestTestListener2 {
    public String caseAuthor = "liuboyang03";
    @Test
    public void test2() {
        Reporter.log("TestTestListener2");
    }
}
