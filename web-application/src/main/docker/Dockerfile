FROM openjdk:8-jre-alpine
MAINTAINER vijayendrap@gmail.com

# environment
EXPOSE 80

# executable ADD @project.artifactId@-@project.version@.jar app.jar
ADD web-application.jar app.jar

# run app as user 'booter'
RUN /bin/sh -c 'touch /app.jar'
ENTRYPOINT ["java", "-Xmx256m", "-Xss32m", "-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
