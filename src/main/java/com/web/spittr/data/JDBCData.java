/**
 * 文件名: JDBCData.java
 * 版权：Copyright 2017-2022 CMCC All Rights Reserved.
 * 描述:
 */
package com.web.spittr.data;

import com.web.spittr.Spitter;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @description:
 * @author: Shenshuaihu
 * @version: 1.0
 * @data: 2019-04-28 11:35
 */
public class JDBCData {
    private static final String SQL_INSERT_SPITTER = "insert into spitter (username, password, first_name) values (?, ?, ?)";
    private DataSource dataSource;

    public void addSpitter(Spitter spitter) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            /**
             * 1、获取连接
             * 2、创建语句
             * 3、绑定参数
             * 4、执行语句
             */
            conn = dataSource.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT_SPITTER);
            stmt.setString(1, spitter.getUsername());
            stmt.setString(2, spitter.getPassword());
            stmt.setString(3, spitter.getFirstName());
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            // 处理异常
        } finally {
            try {
                // 清理资源
                if (stmt !=null) {
                    stmt.close();
                }
                if (conn == null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }


}








