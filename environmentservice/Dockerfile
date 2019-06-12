FROM openjdk:8
copy ./target/environmentservice-0.0.1-SNAPSHOT.jar environmentservice-0.0.1-SNAPSHOT.jar
ENV MONGODB_DB_HOST mongo-db
ENV MONGODB_DB_NAME environmentinfo
CMD ["java","-jar","environmentservice-0.0.1-SNAPSHOT.jar"]