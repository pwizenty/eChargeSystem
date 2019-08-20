# Image für das User-Management-Service erstellt, um Container für den Microservice starten zu können.
FROM openjdk:8
COPY ./target/usermanagementservice-0.0.1-SNAPSHOT.jar usermanagementservice-0.0.1-SNAPSHOT.jar
ENV MONGODB_DB_HOST mongo-db
ENV MONGODB_DB_NAME user
CMD ["java","-jar","usermanagementservice-0.0.1-SNAPSHOT.jar"]