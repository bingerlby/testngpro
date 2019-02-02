/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package com.test.testng.Lesson2DataProvider;

import com.test.testng.MathSolution;
import com.test.testng.common.DataProvider_byDB;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * db存储数据
 *
 * @author binger
 * @created 2018/8/30
 */
public class DBDataProviderTest {
    @DataProvider
    public Iterator<Object[]> dbData() throws ClassNotFoundException, SQLException {
        String sql = "select * from dataprovider where project_name='Test_TestNG'";
        DataProvider_byDB dataProvider_byDB =  new DataProvider_byDB("10.20.93.246", "5002", "test_testng", "testng", "testng", sql);
        return dataProvider_byDB.getDBData();
    }

    @Test(dataProvider = "dbData")
    public void testDBDataProvider(Map<String, String> data) {
        Integer num1 = (data.get("num1") == null) ? null : Integer.valueOf(data.get("num1"));
        Integer num2 = (data.get("num2") == null) ? null : Integer.valueOf(data.get("num2"));
        Integer expect = (data.get("expect") == null) ? null : Integer.valueOf(data.get("expect"));
        String caseDetail = data.get("case_detail").toString();

        Integer sum = MathSolution.Add(num1, num2);
        assertThat(caseDetail, expect, equalTo(sum));
    }
}
