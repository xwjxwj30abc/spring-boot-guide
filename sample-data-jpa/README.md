#学习笔记

```sh
只有需要使用其他配置时使用@PropertySource注解，默认的application.properties会自动加载
@PropertySource(value = { "application.properties" })
```

通过@Value加application.properties调用系统参数
@Value("${server.port}")
	private String port;


在application.properties中声明以下字段，就可以修改默认的嵌入式容器配置而不需要实现EmbeddedServletContainerCustomizer接口
@Component
public class CustomizationEmbeddedServletContainer implements EmbeddedServletContainerCustomizer
server.port=8900
server.address=192.168.6.126
server.sessionTimeout=10000
可以参看package zx.soft.sample.data.jpa.domain.CustomizationEmbeddedServletContaner如何定制嵌入式容器

定制自己的数据源，参见zx.soft.sample.data.jpa.domain.AppConfiguration.java
@Autowired
DataSource dataSource;
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/test
spring.datasource.username=root
spring.datasource.password=root


日志配置：在指定位置处放置logback.xml日志文件
logging.file=logback.xml
logging.level.org.springframework.web: DEBUG
logging.level.org.hibernate: ERROR

安全验证
在pom.xml文件中添加
<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-security</artifactId>
</dependency> 依赖
就可以在application.properties中声明以下字段，为访问接口提供类似于表单一样的验证
security.user.name=admin
security.user.password=test