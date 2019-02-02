/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package com.test.testng;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 在这里编写类的功能描述
 *
 * @author binger
 * @created 2018/9/7
 */
public class FutureSolution {
    public static Integer IntegerNum = 0;
    final static ExecutorService service = Executors.newCachedThreadPool();
    public static Integer getInt() {
        Future<Integer> integerFuture = service.submit(new Callable<Integer>() {
            public Integer call() throws Exception {
                Thread.sleep(5000);
                return IntegerNum = 5;
            }
        });

        return 1;
    }
}
