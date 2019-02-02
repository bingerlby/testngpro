/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package com.test.testng.Lesson5Groups;


/**
 * 在这里编写类的功能描述
 *
 * @author binger
 * @created 2018/9/6
 */

public class GroupTest2 {
    @org.testng.annotations.AfterGroups("group2")
    public void afterGroups() {
        System.out.println("testGroup2-afterGroup");
    }
    @org.testng.annotations.Test(groups = "group2")
    public void testGroup11() {
        System.out.println("testGroup21");
    }

    @org.testng.annotations.Test(groups = {"group1","group2"})
    public void testGroup12() {
        System.out.println("testGroup22");
    }
}
