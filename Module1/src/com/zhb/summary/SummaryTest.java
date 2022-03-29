package com.zhb.summary;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author zhb
 * @create 2022-02-19 22:17
 */
public class SummaryTest {
    //总结
    @Test
    public void testUpdateWithTx() {

        Connection conn = null;
        try {
            //1.获取连接的操作（
            //① 手写的连接：JDBCUtils.getConnection();
            //② 使用数据库连接池：C3P0;DBCP;Druid
            //2.对数据表进行一系列CRUD操作
            //① 使用PreparedStatement实现通用的增删改、查询操作（version 1.0 \ version 2.0)
//version2.0的增删改public void update(Connection conn,String sql,Object ... args){}
//version2.0的查询 public <T> T getInstance(Connection conn,Class<T> clazz,String sql,Object ... args){}
            //② 使用dbutils提供的jar包中提供的QueryRunner类

            //提交数据
            conn.commit();


        } catch (Exception e) {
            e.printStackTrace();


            try {
                //回滚数据
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

        }finally{
            //3.关闭连接等操作
            //① JDBCUtils.closeResource();
            //② 使用dbutils提供的jar包中提供的DbUtils类提供了关闭的相关操作

        }
    }
}
