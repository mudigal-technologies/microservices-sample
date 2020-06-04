# Microservices Sample

[![Build Status](https://travis-ci.org/vmudigal/microservices-sample.svg?branch=master)](https://travis-ci.org/vmudigal/microservices-sample)
[![Docker Repository on Quay](https://quay.io/repository/microservices-sample/api-gateway/status "Docker Repository on Quay")](https://quay.io/repository/microservices-sample/api-gateway)
[![Docker Repository on Quay](https://quay.io/repository/microservices-sample/service-one/status "Docker Repository on Quay")](https://quay.io/repository/microservices-sample/service-one)
[![Docker Repository on Quay](https://quay.io/repository/microservices-sample/service-two/status "Docker Repository on Quay")](https://quay.io/repository/microservices-sample/service-two)
[![Docker Repository on Quay](https://quay.io/repository/microservices-sample/web-application/status "Docker Repository on Quay")](https://quay.io/repository/microservices-sample/web-application)

# Microservices Sample

### What is it?

"Microservices", a trending buzz word nowadays. What problems does it solve?

Many organizations nowadays are driving the technology migrations and one of the biggest challenges is to migrate from monolithic application to micro-services based application.

This microservices-sample project demonstrates how multiple services run independently leveraging on the best microservices patterns to enable scale, performance and resilience.

<p align="center">
  <a href="https://www.youtube.com/watch?v=AYcsnuIOW2M" target="_blank" rel="noopener noreferrer"><img src="https://img.youtube.com/vi/AYcsnuIOW2M/0.jpg" alt="https://www.youtube.com/watch?v=AYcsnuIOW2M"/></a>
</p>

### Use case

The sample application has two services namely service-one and service-two. Each of the service has its own database service-one-db and service-two-db respectively. During the startup of the services, it persists the service name and an auto generated UUID in its perspective database and sends the data to the RabbitMQ exchange which then broadcasts the data to all the queues based on the routing key. Every microservices listens to its own RabbitMQ queue and keeps updating the database as and when it receives the data.

Below are the screens of the application.

![alt tag](https://github.com/vmudigal/microservices-sample/blob/version-5/documents/screens/_Web%20App/01.%20Home.png?raw=true)

Clicking on the tab's one or two the data that you see on the screen is based on the data fetched by the respective service by calling its database.

![alt tag](https://github.com/vmudigal/microservices-sample/blob/version-5/documents/screens/_Web%20App/02.%20One.png?raw=true)

Notice that the UUID generated for service-one which lies in service-one-db is in sync with service-two tab which is achieved by RabbitMQ (asychronous communication between microservices). 

![alt tag](https://github.com/vmudigal/microservices-sample/blob/version-5/documents/screens/_Web%20App/03.%20Two.png?raw=true)

### Service Registration

During the initialization of a service, it would get registered to the discovery and registration server (which in our example is Hashicorp's Consul).

![alt tag](https://github.com/vmudigal/microservices-sample/blob/version-5/documents/sequence-diagram/microservices-sample%20(service%20registration%20sequence).png?raw=true)

#### Service Discovery

 When one service (say api-gateway) needs to access a resource from another service (say service-one), all it has to do is ask discovery and registration server (Consul) to give one of the service-one's instance information.
 
![alt tag](https://github.com/vmudigal/microservices-sample/blob/version-5/documents/sequence-diagram/microservices-sample%20(service%20discovery%20sequence).png?raw=true)

### Architecture

Below is the architectural diagram for microservices sample project.

![alt tag](https://github.com/vmudigal/microservices-sample/blob/version-5/documents/architecture/Infrastructure.png?raw=true)

### Components Integrated & Tools Usage   
##### API Gateway
   
Netflix Zuul is a the reverse proxy server which acts as the API Gateway for accessing the micro services behind the gateway which routes the request to the respective service. Microservice’s stay behind reverse proxy server and needs to be consumed via api gateway. The api-gateway micro service with docker profile runs on port 8080 and can be accessed by http://localhost:8080 .   

Configuration done in API Gateway for Routing:   
```
zuul:
  ignoredServices: '*'
  routes:
    one:
      path: /service-one/**
      serviceId: Service-One
    two:
      path: /service-two/**
      serviceId: Service-Two
```

##### Service registration and discovery   

Registration and discovery is taken care by the HashiCorp’s Consul. During the startup of the individual services, they register with service registration service those details such as host name, port etc. by which the services can be accessed. Once the service is registered to the consul, consul checks for the health of the service by sending a heartbeat for the health check path and health check interval that has been registered with Consul. Requests to the micro-services has to be routed through api-gateway during with the api-gateway contacts discovery service to get the information required to send the request to the intended microservice. 

Configuration done in micro services to register to Consul:   
```
management:
  contextPath: /actuator

spring:
  application.name: service-one
  cloud:
    consul:
      host: consul
      port: 8500
      discovery:
        hostName: service-one
        instanceId:${spring.application.name}:${spring.application.instance_id:${random.value}}
        healthCheckPath: ${management.contextPath}/health
        healthCheckInterval: 15s
```
Consul management console can be accessed at http://localhost:8500/ui/ 

![alt tag](https://github.com/vmudigal/microservices-sample/blob/version-5/documents/screens/Consul/consul.png?raw=true)
 
##### Monitoring and vizualization

Monitoring, visualisation & management of the container in docker is done by weave scope.   

Weavescope management console can be accessed at http://localhost:4040/   

![alt tag](https://github.com/vmudigal/microservices-sample/blob/version-5/documents/screens/Weavescope/weavescope.png?raw=true)

##### Centralized logging using ELK

Logback integrated with every microservices creates application logs and send the log data to the logging server (Logstash). Logstash formats the data and send it to the indexing server (Elasticsearch). The data stored in elasticsearch server can be beautifully visualized using Kibana.   

Accessing tools:   

Elasticsearch: http://localhost:9200/_search?pretty   

Kibana: http://localhost:5601/app/kibana

![alt tag](https://github.com/vmudigal/microservices-sample/blob/version-5/documents/screens/Kibana/kibana.png?raw=true)

##### Asynchronous microservices communication  

Intercommunication between microservices happens asynchronously with the help of RabbitMQ.

RabbitMQ console can be accessed at http://localhost:15672/

![alt tag](https://github.com/vmudigal/microservices-sample/blob/version-5/documents/screens/RabbitMQ/3.rabbit-queues.png?raw=true)

### Technology

Microservices sample project uses a number of open source projects to work properly:

* [SpringBoot] - Application framework
* [Zuul] - API Gateway (Load Balancer)
* [Consul] - Service registration and Discovery
* [Docker] - Containerization platform
* [RabbitMQ] - asynchronous microservices messaging.
* [Logstash] - Log collector
* [Elasticsearch] - Log indexer
* [Kibana] - Data visualization
* [Angular] - HTML enhanced for web apps!
* [Bootstrap] - great UI boilerplate for modern web apps
* [jQuery] - HTML document traversal and manipulation
* [Swagger] - API documentation

### Tools

* [Java] - Programming
* [Maven] - Build
* [Git] - Version control
* [Docker] - Deployment

### Development

Below are the steps to bring up the development environment and get started.

1) Install Git, Java, Maven and Docker</br>
2) For the project using https://github.com/vmudigal/microservices-sample.git
3) Clone the fork using https://github.com/{YOUR_GIT_ID}/microservices-sample.git</br>
4) Execute "cd /microservices-sample/build/docker/scripts/"</br>
5) To deploy docker please run "./deploy.sh docker".</br>
6) Access the Application at http://localhost/</br></br>

### Extras

Mysql on service-two-db:
```
$ docker exec -it service-two-db mysql -u service-two -p
Enter password: service-two

mysql> USE service-two;
Database changed

mysql> SELECT * FROM name_value;

```

### Help

Feel free to reach "vijayendrap@gmail.com" incase of any concerns.

[//]: # (These are reference links used in the body of this note and get stripped out when the markdown processor does its job.)

   [Bootstrap]: <http://twitter.github.com/bootstrap/>
   [jQuery]: <http://jquery.com>
   [Angular]: <https://angular.io/>
   [SpringBoot]: <https://projects.spring.io/spring-boot/>
   [Consul]: <https://www.consul.io>
   [Docker]: <https://www.docker.com>
   [Zuul]: <https://github.com/Netflix/zuul/wiki>
   [Kitematic]: <https://kitematic.com>
   [Maven]: <https://maven.apache.org>
   [MySQL]: <https://www.mysql.com>
   [Git]: <https://git-scm.com>
   [Java]: <https://go.java>
   [Logstash]: <https://www.elastic.co/products/logstash>
   [Elasticsearch]: <https://www.elastic.co/products/elasticsearch>
   [Kibana]: <https://www.elastic.co/products/kibana>
   [RabbitMQ]: <https://www.rabbitmq.com/>
   [Swagger]: <https://swagger.io/>
   
