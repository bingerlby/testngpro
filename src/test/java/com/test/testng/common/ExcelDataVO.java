/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package com.test.testng.common;

/**
 * excel中数据模型
 *
 * @author binger
 * @created 2018/8/30
 */
public class ExcelDataVO<T> {
    public Double []args;
    public String caseDetail;
    public String expect;

    public String getCaseDetail() {
        return caseDetail;
    }

    public void setCaseDetail(String caseDetail) {
        this.caseDetail = caseDetail;
    }

    public Double[] getArgs() {
        return args;
    }

    public void setArgs(Double[] args) {
        this.args = args;
    }

    public String getExpect() {
        return expect;
    }

    public void setExpect(String expect) {
        this.expect = expect;
    }
}
