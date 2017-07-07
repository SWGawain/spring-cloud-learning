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
这个包整合了cloud大部分需要的功能，starter包中的内容相对较少
    

11. 讲真，我觉得rest这种方式有点轻，来回转换json并不友好，应该搞搞gRPC



