FROM gradle:jdk17 AS build
WORKDIR /src
COPY build.gradle settings.gradle ./
COPY src ./src
RUN gradle --no-daemon clean assemble -x test

FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /src/build/libs/*.jar ./app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-cp", "/app/app.jar", "com.efd.App"]