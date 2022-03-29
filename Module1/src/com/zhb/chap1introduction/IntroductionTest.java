package com.zhb.chap1introduction;

/**
 * @author zhb
 * @create 2022-02-19 15:17
 */

/**
 * 第1章：JDBC概述
 * 1.1 数据的持久化
 * 1.2 Java中的数据存储技术
 * 1.3 JDBC介绍
 * 1.4 JDBC体系结构
 * 1.5 JDBC程序编写步骤
 *
 */

/*
### 1.2 Java中的数据存储技术

- 在Java中，数据库存取技术可分为如下几类：
  - **JDBC**直接访问数据库
  - JDO (Java Data Object )技术

  - **第三方O/R工具**，如Hibernate, Mybatis 等

- JDBC是java访问数据库的基石，JDO、Hibernate、MyBatis等只是更好的封装了JDBC。


### 1.3 JDBC介绍

- JDBC(Java Database Connectivity)是一个**独立于特定数据库管理系统、通用的SQL数据库存取和操作的公共接口**（一组API），定义了用来访问数据库的标准Java类库，（**java.sql,javax.sql**）使用这些类库可以以一种**标准**的方法、方便地访问数据库资源。
- JDBC为访问不同的数据库提供了一种**统一的途径**，为开发者屏蔽了一些细节问题。
- JDBC的目标是使Java程序员使用JDBC可以连接任何**提供了JDBC驱动程序**的数据库系统，这样就使得程序员无需对特定的数据库系统的特点有过多的了解，从而大大简化和加快了开发过程。
- 如果没有JDBC，那么Java程序访问数据库时是这样的：
java应用程序
连接
MySQl\Oracle\SQLServer\DB2
我们认为的连接应如此
java应用程序
调用
JDBC（一组规范：接口）
具体实现
MySQl\Oracle\SQLServer\DB2

真实的连接是这样：
java应用程序（直接调JDBCMysqllmpl可行，但移植性差）
调用
JDBC（一组规范：接口）
(JDBC驱动)JDBCMysqllmpl\JDBCOraclelmpl\JDBCSQLServerlmpl\JDBCDB2lmpl
MySQl\Oracle\SQLServer\DB2

### 1.4 JDBC体系结构

- JDBC接口（API）包括两个层次：
  - **面向应用的API**：Java API，抽象接口，供应用程序开发人员使用（连接数据库，执行SQL语句，获得结果）。
  - **面向数据库的API**：Java Driver API，供开发商开发数据库驱动程序用。

> **JDBC是sun公司提供一套用于数据库操作的接口，java程序员只需要面向这套接口编程即可。**
>
> **不同的数据库厂商，需要针对这套接口，提供不同实现。不同的实现的集合，即为不同数据库的驱动。																————面向接口编程**

### 1.5 JDBC程序编写步骤
开始
    导入java.sql包
    附加相应产商提供的驱动（纯java驱动方式，Oracle，MySQL）|建立数据源（ODBC）SQL Server（JDBC-ODBC桥方式）
    加载并注册驱动程序
    创建connection对象
    创建Statement对象
        执行SQL语句
            查询
        使用ResultSet对象
        关闭ResultSet对象（更新（执行SQL语句））
    关闭Statement对象
    关闭connection对象
结束


> 补充：ODBC(**Open Database Connectivity**，开放式数据库连接)，是微软在Windows平台下推出的。使用者在程序中只需要调用ODBC API，由 ODBC 驱动程序将调用转换成为对特定的数据库的调用请求。


 */
public class IntroductionTest {
}
