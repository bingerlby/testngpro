/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package com.test.testng.Lesson12ReportListeners;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

/**
 * 在这里编写类的功能描述
 *
 * @author binger
 * @created 2018/9/10
 */
public class TestReportNG {
    @DataProvider
    public Object[][] getData() {
        return new Object[][] {
                {"第一条数据", "一"},
                {"第二条数据", "一"}
        };
    }

    @Test(dataProvider = "getData")
    public void testReportNG(String data, String expect) {
        assertThat(data, containsString(expect));
        Reporter.log("lalala 测试通过哦～");
    }

    @Test
    public void testReportNG2() {
        Reporter.log("lalala 我是测试输出的log数据哦～");
    }
}
