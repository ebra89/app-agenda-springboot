FROM openjdk:8
ADD target/app-agenda-springboot.jar app-agenda-springboot.jar
EXPOSE 8089
ENTRYPOINT ["java","-jar","app-agenda-springboot.jar"]