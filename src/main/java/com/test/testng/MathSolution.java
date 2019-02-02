/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package com.test.testng;

import java.math.BigInteger;

/**
 * 在这里编写类的功能描述
 *
 * @author binger
 * @created 2018/8/30
 */
public class MathSolution {
    public static Integer Add(Integer num1, Integer num2) {
        if (num1 == null || num2 == null) {
            return null;
        }
        if (BigInteger.valueOf(num1).add(BigInteger.valueOf(num2)).compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) > 0) {
            return null;
        }
        return num1 + num2;
    }

    public static Integer divide(Integer num1, Integer num2) throws NumberFormatException{
        if (num2.equals(0)) {
            throw new NumberFormatException("除数不能为0");
        }
        return num1/num2;
    }
}
