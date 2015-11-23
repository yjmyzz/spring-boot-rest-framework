# spring-boot-rest-framework  
基于spring-boot的rest微服务框架

####数据访问层

dao采用mybatis 3.3.0 + tk.mybatis通用Mapper3.1.3 , 支持事务回滚

####web容器

内嵌tomcat容器,默认开启gzip压缩

####日志及监控

所有controller层的参数利用AOP机制自动记录日志及自动计算服务端耗时(毫秒数)

####参数校验

参数对象采用注解方式自动校验,支持自定义注解

####返回结果

服务结果以json格式返回,如果服务层发生异常,返回结果中自带errorCode及errorDesc,不论服务端方法执行成功与否,均会返回执行结果及服务端耗时

####浏览地址

程序入口类为spring.boot.rest.demo.main.DemoRestApplication,应用启动后,浏览http://localhost:8080/ping,正常情况下,应该返回类似:
```javascript
{
    "data": "running",
    "errorCode": null,
    "errorDesc": null,
    "elapsedMilliseconds": ​0,
    "success": true
}
```
---  

使用过程中如有任何问题请联系:[菩提树下的杨过](http://yjmyzz.cnblogs.com/ "http://yjmyzz.cnblogs.com/")
