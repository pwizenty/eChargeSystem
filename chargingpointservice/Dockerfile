FROM openjdk:8
copy ./target/chargingpointservice-0.0.1-SNAPSHOT.jar chargingpointservice-0.0.1-SNAPSHOT.jar
ENV MONGODB_DB_HOST mongo-db
ENV MONGODB_DB_NAME chargingpoint
CMD ["java","-jar","chargingpointservice-0.0.1-SNAPSHOT.jar"]