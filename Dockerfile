FROM openjdk:11-jdk-slim

ADD ./target/like-service.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/like-service.jar"]

EXPOSE 8064