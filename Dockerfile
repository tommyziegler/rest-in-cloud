FROM java:8

MAINTAINER Tommy Ziegler <tommy.ziegler@opitz-consulting.com>

RUN echo 'Building docker image for rest-in-cloud demo application...'

VOLUME /tmp

ENV spring.profiles.active dev

EXPOSE 8080

COPY target/rest-in-cloud-0.0.1-SNAPSHOT.jar rest-in-cloud.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/rest-in-cloud.jar"]