package com.test.testng.common;

import org.testng.collections.Lists;

import java.sql.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class DataProvider_byDB {

    ResultSet rs;
    ResultSetMetaData rd;

    public DataProvider_byDB(String ip, String port, String baseName, String userName, String password, String sql) throws ClassNotFoundException, SQLException {
        // 连接数据库
        Class.forName("com.mysql.jdbc.Driver");

        // 连接数据库
        String url = String.format("jdbc:mysql://%s:%s/%s", ip, port, baseName);
        Connection conn = DriverManager.getConnection(url, userName, password);
        Statement createStatement = conn.createStatement();

        // 执行SQL命令，并返回符合条件的记录
        rs = createStatement.executeQuery(sql);
        rd = rs.getMetaData();
    }

    public Iterator<Object[]> getDBData() {
        List<Object[]> ret = Lists.newArrayList();

        while (hasNext()) {
            Object[] tmp = next();
            ret.add(tmp);
        }

        return ret.iterator();
    }

    private boolean hasNext() {
        boolean flag = false;
        try {
            flag = rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    private Object[] next() {
        Map<String, String> data = new HashMap<String, String>();
        try {
            for (int i = 1; i <= rd.getColumnCount(); i++) {
                data.put(rd.getColumnName(i), rs.getString(i));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Object r[] = new Object[1];
        r[0] = data;
        return r;
    }
}
