ES + SB2.x + JPA + MySQL

练习项目，目的为学习 ES，时间有限，缓慢学习.

原项目是基于 SB1.x 的，自己尝试改为 SB2.x，有许多坑，缓慢解决中...

SpringBoot 自动配置虽好，但也是因为这个导致 SB 是个黑箱，如果进行自定义，不了解的情况下很难....

## 配置解释
虽然使用了 SB，但是还是用了大量的 Configuration;

PlatformTransactionManager：

关于事务管理器，不管是 JPA 还是 JDBC 等都实现自接口 PlatformTransactionManager ；

如果你添加的是 spring-boot-starter-jdbc 依赖，框架会默认注入 DataSourceTransactionManager 实例。

如果你添加的是 spring-boot-starter-data-jpa 依赖，框架会默认注入 JpaTransactionManager 实例。

---

LocalContainerEntityManagerFactoryBean：

在 JPA 的环境下，使用 LocalContainerEntityManagerFactoryBean 用来确定使用哪一种 JPA 的实现，以此来操作数据库。

非 JPA 的情况，我们使用 LocalSessionFactoryBean 用来创建 session 来进行数据库的操作。 

jpaVendorAdapter 属性用于指明所使用的是哪一个厂商的 JPA 实现。Spring 提供了多个 JPA 厂商适配器：
- EclipseLinkJpaVendorAdapter
- HibernateJpaVendorAdapter
- OpenJpaVendorAdapter
- TopLinkJpaVendorAdapter（在Spring 3.1版本中，已经将其废弃了）

---

com.mysql.jdbc.Driver 是 mysql-connector-java 5 中的， 
com.mysql.cj.jdbc.Driver 是 mysql-connector-java 6 中的.

如果 mysql-connector-java 用的 6.0 以上的，需要使用 com.mysql.cj.jdbc.Driver，并且要指定时区

```properties
url5=jdbc:mysql://localhost:3306/test?useSSL=true&characterEncoding=UTF-8

url6+=jdbc:mysql://127.0.0.1:3306/test?serverTimezone=Asia/Shanghai&useSSL=true&characterEncoding=UTF-8
```

SpringBoot2.x 的 datasource 使用了 hikari 相比之前有了一些小的变化，例如 url 改为了 jdbc-url，在手动注入 DS 或者多数据源的时候要注意。