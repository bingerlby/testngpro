/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package com.test.testng.Lesson8Ignore;

import org.testng.annotations.Test;

/**
 * 在这里编写类的功能描述
 *
 * @author binger
 * @created 2018/9/7
 */
public class IgnoreTest {
    @Test(enabled = false)
    public void ignoreTest() {
        System.out.println("被忽略的测试");
    }

    @Test
    public void noIgnoreTest() {
        System.out.println("不被忽略的测试");
    }
}
