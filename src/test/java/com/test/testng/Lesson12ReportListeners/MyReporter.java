/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package com.test.testng.Lesson12ReportListeners;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.xml.XmlSuite;

import java.util.List;

/**
 * 在这里编写类的功能描述
 *
 * @author binger
 * @created 2018/9/10
 */
public class MyReporter implements IReporter {
    /**
     * Generate a report for the given suites into the specified output directory.
     *
     * @param xmlSuites
     * @param suites
     * @param outputDirectory
     */
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {

    }
}
