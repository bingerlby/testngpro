/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package com.test.testng.Lesson7Exception;

import com.test.testng.MathSolution;
import org.testng.annotations.Test;

/**
 * 在这里编写类的功能描述
 *
 * @author binger
 * @created 2018/9/7
 */
public class ExceptionTest {
    //不抛出异常Test失败
    @Test(expectedExceptions = {NumberFormatException.class, Exception.class})
    public void testException() {
        MathSolution.Add(1, 2);
    }

    //抛出异常Test成功
    @Test(expectedExceptions = {NumberFormatException.class})
    public void testException2() {
        MathSolution.divide(1, 0);
    }
}
