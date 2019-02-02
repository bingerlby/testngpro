/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package com.test.testng.Lesson0Annotation;

/**
 * 注解使用
 *
 * @author binger
 * @created 2018/8/27
 */
public class TestAnnotation2 {
    @org.testng.annotations.BeforeTest
    public void beforeTest() {
        System.out.println("**********TestAnnotation2--Test执行之前操作**********");
    }

    @org.testng.annotations.AfterTest
    public void afterTest() {
        System.out.println("==========TestAnnotation2--Test执行之后操作==========");
    }

    @org.testng.annotations.BeforeClass
    public void beforeClass() {
        System.out.println("**********TestAnnotation2--Class执行之前操作**********");
    }

    @org.testng.annotations.AfterClass
    public void afterClass() {
        System.out.println("==========TestAnnotation2--Class执行之后操作==========");
    }

    @org.testng.annotations.BeforeMethod
    public void beforeMethod() {
        System.out.println("**********TestAnnotation2--Method执行之前操作**********");
    }

    @org.testng.annotations.AfterMethod
    public void afterMethod() {
        System.out.println("==========TestAnnotation2--Method执行之后操作==========");
    }

    @org.testng.annotations.Test
    public void testMethod1() {
        System.out.println("==========TestAnnotation2--testMethod1执行==========");
    }

    @org.testng.annotations.Test
    public void testMethod2() {
        System.out.println("==========TestAnnotation2--testMethod2执行==========");
    }
}
