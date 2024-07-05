FROM maven AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests
FROM openjdk:17
WORKDIR /app
COPY --from=build /app/target/crashandburn-0.0.1-SNAPSHOT.jar ./crashnburn.jar
CMD ["java","-jar","crashnburn.jar"]
