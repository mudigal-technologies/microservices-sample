### What is it?

"Microservices", a trending buzz word nowadays. What problems does it solve?

Many organizations nowadays are driving the technology migrations and one of the biggest challenges is to migrate from monolithic application to micro-services based application.

Below is an example application which you could refer and get the answers for the problems that it solves by yourself. In the example below, there are multiple services that could be deployed in any datacenters on the global. When we start a service, it would be registered to the discovery and registration server (Consul). When one service (say service-one) needs to access a resource from another service (say service-two), all it has to do is ask discovery and registration server (Consul) to give one of the service-one instance information.

Microservices sample project is a cloud-enabled, microservices based, mobile-ready, scalable, resilient, AngularJS powered HTML5 Application.

### Architecture

Below is the architectural diagram for microservices sample project.

![alt tag](https://raw.githubusercontent.com/vmudigal/microservices-sample/version-two/documents/Architectue.jpg)

### Technology

Microservices sample project uses a number of open source projects to work properly:

* [SpringBoot] - Application framework
* [Zuul] - API Gateway (Load Balancer)
* [Consul] - Service registration and Discovery
* [Docker] - Containerization platform
* [Logstash] - Log collector
* [Elasticsearch] - Log indexer
* [Kibana] - Data visualization
* [AngularJS] - HTML enhanced for web apps!
* [Bootstrap] - great UI boilerplate for modern web apps
* [jQuery] - HTML document traversal and manipulation

### Tools

* [Java] - Programming
* [Maven] - Build
* [Git] - Version control
* [Docker] - Deployment

### Development

Below are the steps to bring up the development environment and get started.

1) Install Git, Java, Maven and Docker</br>
2) Clone the project using https://github.com/vmudigal/microservices-sample.git</br>
3) Execute "cd /microservices-sample/build/docker/scripts/"</br>
4) To deploy docker please run "./deploy.sh docker".</br>
5) Access the Application at http://localhost/</br></br>

### Help

Feel free to reach "vijayendrap@gmail.com" incase of any concerns.

[//]: # (These are reference links used in the body of this note and get stripped out when the markdown processor does its job.)

   [Bootstrap]: <http://twitter.github.com/bootstrap/>
   [jQuery]: <http://jquery.com>
   [AngularJS]: <http://angularjs.org>
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
   
