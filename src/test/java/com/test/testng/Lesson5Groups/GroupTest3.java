/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package com.test.testng.Lesson5Groups;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * 在这里编写类的功能描述
 *
 * @author binger
 * @created 2018/9/6
 */
@Test(groups = "group3")
public class GroupTest3 {
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("testGroup3-beforeMethod");
    }

    @Test
    public void testGroup3() {
        System.out.println("testGroup3-test");
    }
}
