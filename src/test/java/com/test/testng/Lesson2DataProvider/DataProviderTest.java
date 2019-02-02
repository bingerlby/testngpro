/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package com.test.testng.Lesson2DataProvider;

import com.test.testng.MathSolution;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * dataProvider使用
 *
 * @author binger
 * @created 2018/8/30
 */
public class DataProviderTest {
    @BeforeClass
    public void BeforeClass() {
        System.out.println("Before Class");
    }

    @BeforeMethod
    public void BeforeMethod() {
        System.out.println("Before Method");
    }

    @DataProvider
    public Object[][] paramData() {
        return new Object[][] {
                {"Add 1 + 2", 1, 2, 3},
                {"Add null + null", null, null, null},
                {"Add Big", Integer.MAX_VALUE, Integer.MAX_VALUE, null}
        };
    }

    @Test(dataProvider="paramData")
    public void testDataProvider(String caseDetail, Integer num1, Integer num2, Integer expect) {
        Integer sum = MathSolution.Add(num1, num2);
        assertThat(caseDetail, expect, equalTo(sum));
        System.out.println(Integer.MAX_VALUE);
    }
}
