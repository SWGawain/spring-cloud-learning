# springboot-learning
springboot learning data

Finished :

1.修改内置tomcat启动端口

2.配置datasource，可以在application.properties中配置，然后直接注入

3.配置mybatis以及注解式配置

   * 注解无法实现sql集合的复用
   * application.propertis中可以用mybatis.mapper-locations
   来引入原来的mapper文件
   * mapper文件可以和注解一起使用，也就是说，sql集合可以定义在
   mapper文件中，其他的全都可以用注解
   * @MapperScan注解可以开启扫描所有的mapper接口
   
4.redis的配置
   
   * cluster配置，不是用','来分割，而是用数组的方式注入
   这是springboot对list变量的特殊解析方式

5.@RestController等于@Controller外加所有方法自带@ResponseBody

6.@ConfigurationProperties可以方便变量从配置文件中取值，
但是需要写setter和getter方法

7.@Value也可以获取properties中的值，而且可以不用写setter和getter

  * 表达式${aaa}，意思是直接取 aaa 的值
  * 表达式#{ 'a'.split(',')}，可以写java代码。。。

8.@EnableTransactionManagement启动事务支持

9.@Bean标签等于xml中<bean>

10.logger可以直接在application.properties中配置，
用的是slf4j的log，貌似可以省了logback的配置文件

11.@SpringBootApplication就是总入口，同时会扫描这个类包结构之下
的所有的注解

12.@PropertySource允许额外的properties文件

13.@ImportResource允许加入额外的spring xml文件

14.main方法里直接运行SpringApplication.run(SpringbootDemoApplication.class, args);
就可以启动内置tomcat开服务，打包成jar包直接运行也可以，war包也可以，maven插件运行也可以。。。

15.想用maven的resources插件做多环境配置的话，只允许application.properties做过滤，
也就是说，改什么文件都没用，只能用多环境做这一个文件，用法不再是${}，而是 aa = @aa@，
不太推荐这么玩，我觉得spring-cloud-config搞这个多环境应该更好

16.@RunWith(SpringRunner.class)和@SpringBootTest是springboot特殊的junit+spring环境的配置方式



   
   
