/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package com.test.testng.Lesson2DataProvider;

import com.test.testng.MathSolution;
//import com.test.testng.common.ExcelUtil;
import com.test.testng.common.ExcelUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * excel方式存储数据
 *
 * @author binger
 * @created 2018/8/30
 */
public class ExcelDataProviderTest {
    @DataProvider
    public Iterator<Object[]> excelData() {
        return new ExcelUtils("src/test/java/com/test/testng/data/exceldata.xlsx", "工作表1");
    }

    @Test(dataProvider = "excelData")
    public void testExcelDataProvider(Map<String, Object> data) {
        String caseDetail = data.get("caseDetail").toString();
        Integer num1 = data.get("num1").equals("null") ? null : Double.valueOf(data.get("num1").toString()).intValue();
        Integer num2 = data.get("num2").equals("null") ? null : Double.valueOf(data.get("num2").toString()).intValue();
        Integer expectNum = data.get("expect").equals("null") ? null : Double.valueOf(data.get("expect").toString()).intValue();
        Integer sum = MathSolution.Add(num1, num2);
        assertThat(caseDetail, expectNum, equalTo(sum));
    }

}
