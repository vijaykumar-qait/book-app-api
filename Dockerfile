#official run time jdk env
FROM openjdk:17-jdk-slim

#working directory in container
WORKDIR /app

#copy jar from host to container
COPY target/book-app-api.jar /app/book-app-api.jar

#Expose the port for app to run on
EXPOSE 8082

#Entry point to run java application
ENTRYPOINT ["java", "-jar", "/app/book-app-api.jar"]
