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
@Test(groups = "init")
public class ToBeDependGroups {
    public void initUser() {
        System.out.println("initUser");
    }

    public void initConf() {
        System.out.println("initConf");
    }
}
