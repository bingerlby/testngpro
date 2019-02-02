/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package com.test.testng.Lesson11AnnotationTransformer;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * 在这里编写类的功能描述
 *
 * @author binger
 * @created 2018/9/10
 */
public class TestAnnotationTransformer2 {
    @DataProvider
    public Object[][] getData() {
        return new Object[][] {
                {"123"}
        };
    }

    @Test
    public void test2(String str) {
        System.out.println("TestAnnotationTransformer2 " + str);
    }
}
