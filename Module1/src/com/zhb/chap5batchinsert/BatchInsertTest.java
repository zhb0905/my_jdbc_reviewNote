package com.zhb.chap5batchinsert;

/**
 * @author zhb
 * @create 2022-02-19 18:54
 */

/**
 * 第5章 批量插入
 * 5.1 批量执行SQL语句
 * 5.2 高效的批量插入
 *      5.2.1 实现层次一：使用Statement
 *      5.2.2 实现层次二：使用PreparedStatement
 *      5.2.3 实现层次三
 *      5.2.4 实现层次四
 */
/*
 ### 5.1 批量执行SQL语句

当需要成批插入或者更新记录时，可以采用Java的批量**更新**机制，这一机制允许多条语句一次性提交给数据库批量处理。通常情况下比单独提交处理更有效率

JDBC的批量处理语句包括下面三个方法：

- **addBatch(String)：添加需要批量处理的SQL语句或是参数；**
- **executeBatch()：执行批量处理语句；**
- **clearBatch():清空缓存的数据**

通常我们会遇到两种批量执行SQL语句的情况：

- 多条SQL语句的批量处理；
- 一个SQL语句的批量传参；

 */

/*


### 5.2 高效的批量插入

举例：向数据表中插入20000条数据

- 数据库中提供一个goods表。创建如下：
CREATE TABLE goods(
id INT PRIMARY KEY AUTO_INCREMENT,
NAME VARCHAR(20)
);

 */
// #### 5.2.1 实现层次一：使用Statement
//
//            ```java
//            Connection conn = JDBCUtils.getConnection();
//            Statement st = conn.createStatement();
//            for(int i = 1;i <= 20000;i++){
//            String sql = "insert into goods(name) values('name_' + "+ i +")";
//            st.executeUpdate(sql);
//            }
//            ```
//
//
//
// #### 5.2.2 实现层次二：使用PreparedStatement
//
//            ```java
//            long start = System.currentTimeMillis();
//
//            Connection conn = JDBCUtils.getConnection();
//
//            String sql = "insert into goods(name)values(?)";
//            PreparedStatement ps = conn.prepareStatement(sql);
//            for(int i = 1;i <= 20000;i++){
//            ps.setString(1, "name_" + i);
//            ps.executeUpdate();
//            }
//
//            long end = System.currentTimeMillis();
//            System.out.println("花费的时间为：" + (end - start));//82340
//
//
//            JDBCUtils.closeResource(conn, ps);
//            ```
//
//#### 5.2.3 实现层次三
/*
 * 修改1： 使用 addBatch() / executeBatch() / clearBatch()
 * 修改2：mysql服务器默认是关闭批处理的，我们需要通过一个参数，让mysql开启批处理的支持。
 * 		 ?rewriteBatchedStatements=true 写在配置文件的url后面
 * 修改3：使用更新的mysql 驱动：mysql-connector-java-5.1.37-bin.jar
 *
 */
//
//import org.junit.jupiter.api.Test;
//
//@Test
//public void testInsert1() throws Exception{
//        long start = System.currentTimeMillis();
//
//        Connection conn = JDBCUtils.getConnection();
//
//        String sql = "insert into goods(name)values(?)";
//        PreparedStatement ps = conn.prepareStatement(sql);
//
//        for(int i = 1;i <= 1000000;i++){
//        ps.setString(1, "name_" + i);
//
//        //1.“攒”sql
//        ps.addBatch();
//        if(i % 500 == 0){
//        //2.执行
//        ps.executeBatch();
//        //3.清空
//        ps.clearBatch();
//        }
//        }
//
//        long end = System.currentTimeMillis();
//        System.out.println("花费的时间为：" + (end - start));//20000条：625                                                                         //1000000条:14733
//
//        JDBCUtils.closeResource(conn, ps);
//        }

//5.2.4 实现层次四
///*
// * 层次四：在层次三的基础上操作
// * 使用Connection 的 setAutoCommit(false)  /  commit()
// */
//
//import org.junit.jupiter.api.Test;
//
//@Test
//public void testInsert2() throws Exception{
//        long start = System.currentTimeMillis();
//
//        Connection conn = JDBCUtils.getConnection();
//
//        //1.设置为不自动提交数据
//        conn.setAutoCommit(false);
//
//        String sql = "insert into goods(name)values(?)";
//        PreparedStatement ps = conn.prepareStatement(sql);
//
//        for(int i = 1;i <= 1000000;i++){
//        ps.setString(1, "name_" + i);
//
//        //1.“攒”sql
//        ps.addBatch();
//
//        if(i % 500 == 0){
//        //2.执行
//        ps.executeBatch();
//        //3.清空
//        ps.clearBatch();
//        }
//        }
//
//        //2.提交数据
//        conn.commit();
//
//        long end = System.currentTimeMillis();
//        System.out.println("花费的时间为：" + (end - start));//1000000条:4978
//
//        JDBCUtils.closeResource(conn, ps);
//        }

public class BatchInsertTest {
}
