/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package com.test.testng.Lesson1Simple;

import com.test.testng.MathSolution;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * 一个简单的例子
 *
 * @author binger
 * @created 2018/8/30
 */
public class SimpleTest {
    @BeforeClass
    public void BeforeClass() {
        System.out.println("Before Class");
    }

    @BeforeMethod
    public void BeforeMethod() {
        System.out.println("Before Method");
    }

    @Test
    public void testAdd() {
        Integer sum1 = MathSolution.Add(1, 2);
        assertThat("Add 1 + 2 结果错误", sum1, equalTo(3));
    }

    @Test
    public void testAdd2() {
        Integer sum2 = MathSolution.Add(null, null);
        assertThat("Add null + null 结果错误", sum2, equalTo(null));
    }

    @Test
    public void testAdd3() {
        Integer sum3 = MathSolution.Add(Integer.MAX_VALUE, Integer.MAX_VALUE);
        assertThat("Too Big", sum3, equalTo(null));
    }

}
