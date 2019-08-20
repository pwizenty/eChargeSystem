# Definiert das Image für den Environment-Service, um das Microservice als Container zu starten
FROM openjdk:8
COPY ./target/environmentservice-0.0.1-SNAPSHOT.jar environmentservice-0.0.1-SNAPSHOT.jar
ENV MONGODB_DB_HOST mongo-db
ENV MONGODB_DB_NAME environmentinfo
CMD ["java","-jar","environmentservice-0.0.1-SNAPSHOT.jar"]