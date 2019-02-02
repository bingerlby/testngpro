/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package com.test.testng.Lesson4Factory;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * dataprovider，相同实例
 *
 * @author binger
 * @created 2018/9/4
 */
public class Test2 {
    @DataProvider
    public Object[][] getData() {
        return new Object[][]{
                {1},
                {2}
        };
    }

    //两个相同实例
    @Test(dataProvider = "getData")
    public void test(int count) {
        System.out.println("Test2-相同实例地址-" + this);
        for (int i = 0; i < count; i++) {
            System.out.println("Test2-test-" + i);
        }
    }
}
