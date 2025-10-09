# ---- Build stage ----
FROM eclipse-temurin:17-jdk AS build
WORKDIR /app
COPY . .
RUN ./gradlew clean build -x test || gradle clean build -x test
RUN JAR_PATH=$(find build/libs -maxdepth 1 -name "*SNAPSHOT.jar" -o -name "*RELEASE.jar" | head -n 1) \
 && cp "$JAR_PATH" /app/app.jar

# ---- Runtime stage ----
FROM eclipse-temurin:17-jre
ENV JAVA_OPTS="-XX:+UseContainerSupport -XX:MaxRAMPercentage=75"
ENV PORT=8080
WORKDIR /app
COPY --from=build /app/app.jar /app/app.jar
CMD ["sh","-c","java $JAVA_OPTS -Dserver.port=${PORT} -jar /app/app.jar"]
