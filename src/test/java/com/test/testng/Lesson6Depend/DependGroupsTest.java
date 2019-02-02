/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package com.test.testng.Lesson6Depend;

import org.testng.annotations.Test;

/**
 * 在这里编写类的功能描述
 *
 * @author binger
 * @created 2018/9/7
 */
public class DependGroupsTest {
    @Test(dependsOnGroups = "init")
    public void dependOnGroupTest() {
        System.out.println("dependOnGroupTest");
    }
}
