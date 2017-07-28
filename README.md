spring-cloud-eureka

1. eureka.client.register-with-eureka=false
eureka.client.fetch-registry=false
eureka.client.serviceUrl.defaultZone=http://localhost:${server.port}/eureka/
eureka服务中，增加上述配置，避免自己注册自己的情况

2. @EnableEurekaServer  开启eureka服务器，启动服务发现
 
3. @EnableEurekaClient 
eureka.client.serviceUrl.defaultZone=http://localhost:8081/eureka/
开启eureka客户端，向服务端注册自己的服务

4. spring.application.name=config-service 通过这个指定服务的名称

5. eureka服务器自带展示页面，直接访问localhost:8080就可以看到

6. @EnableDiscoveryClient 调用方允许使用服务自动发现来调用接口

7. DiscoveryClient属于eureka包中的类，这个包里应该有对服务发现的各种支持

8. 调用方可以请求eureka之后，用ribbon来做客户端负载均衡，在RestTemplate上声明@LoadBalanced

9. 调用方可以用Feign来做api化的RPC调用，集成了ribbon功能
@EnableFeignClients 开启feign功能
@FeignClient("config-service") 指定该接口中的方法指向的服务
@RequestMapping("/add")指定接口中每个方法通向的http地址

10. 
```
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-dependencies</artifactId>
    <version>Dalston.SR1</version>
    <type>pom</type>
    <scope>import</scope>
</dependency>

```
这个包整合了cloud大部分需要的功能，starter包中的内容相对较少，新的spring-cloud发版不再以数字为版本号
改为人名，从A到Z

11. 讲真，我觉得rest这种方式有点轻，来回转换json并不友好，应该搞搞gRPC

12. docker是个好东西，往后更多的服务启动，本地一个个的跑jar包或者tomcat，估计都是玩不起的。。

13. eureka服务高可用，用两个节点互相注册，然后服务方同时注册这两个点

14. eureka.instance.hostname这个配置在docker启动时务必注意，如果不配置，会获取docker的容器名
同样的，server.port如果不配置，用默认的8080的话，那么在eureka节点上就会用8080注册，
这里注意，如果是用docker启动的话，容器间需要额外配置互访端口和vhosts，另外docker集群的话，容器互访的配置难度则会更大，
所以我觉得还是配好固定的端口和ip比较好，改起来麻烦的话，放在pom里也行

15. config热部署需要@RefreshScope，需要spring-boot-starter-actuator包，需要对security做额外的控制或直接关闭
/refresh可以让应用刷新配置，但是只刷新RefreshScope标签标记过的，而且只支持POST请求

16. 熔断器这个东西Feign包是集成过的，@FeignClient(value = "config",fallback = ComputeServiceImpl.class)
接口上的这个声明，会在需要熔断的时候，找ComputeServiceImpl.class这个类里的方法，
换句话理解，这个接口是要用REST调用的，然而触发熔断的时候，就不再去找RPC了，而是去找接口对应的实现类和实现方法
说白了，给个默认处理方法
如果不用Feign包，那就得加上hystrix的包，所谓熔断嘛，就像电闸，功率过大了，就及时断掉，对应到我们的代码
就是调用时间太长了，那就先别调用了，不要让前面的应用拖死后面的，那么这里有个问题，就是gRPC的情况下，怎么集成这个熔断器
果然还是应该有抽时间研究下


