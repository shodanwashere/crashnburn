FROM maven@sha256:7a3388321715e15d86f6b540deadeb5cf3e19ac939eda6b94e5e44c681782e9d AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests
FROM openjdk:17
WORKDIR /app
COPY --from=build /app/target/crashandburn-0.0.1-SNAPSHOT.jar ./crashnburn.jar
CMD ["java","-jar","crashnburn.jar"]
