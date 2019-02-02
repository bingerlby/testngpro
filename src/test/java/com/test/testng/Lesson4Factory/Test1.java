/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package com.test.testng.Lesson4Factory;

import org.testng.annotations.Test;

/**
 * Test1
 *
 * @author binger
 * @created 2018/9/4
 */
public class Test1 {
    private int count;

    public Test1(int count) {
        this.count = count;
    }

    //两个不同实例
    @Test
    public void test() {
        System.out.println("Test1-不同实例地址-" + this);
        for (int i = 0; i < count; i++) {
            System.out.println("Test1-test-" + i);
        }
    }
}
