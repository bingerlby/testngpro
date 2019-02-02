/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package com.test.testng.Lesson4Factory;

import org.testng.annotations.Factory;

/**
 * factory,创建多个实例
 *
 * @author binger
 * @created 2018/9/4
 */
public class FactoryTest {
    @Factory
    public Object[] factoryTest1() {
        return new Object[]{new Test1(1), new Test1(2)};
    }
}
