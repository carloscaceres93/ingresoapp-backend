FROM maven:3.8.1-openjdk-8 AS TEMP_BUILD_IMAGE
ENV APP_HOME=/usr/app/
WORKDIR $APP_HOME
COPY . .
COPY ./prod.application.properties ./src/main/resources/application.properties
RUN mvn package -DskipTests

FROM openjdk:8
ENV ARTIFACT_NAME=ingreso-0.0.1-SNAPSHOT.jar
ENV APP_HOME=/usr/app/
WORKDIR $APP_HOME
COPY --from=TEMP_BUILD_IMAGE $APP_HOME/target/$ARTIFACT_NAME .
CMD java -jar $ARTIFACT_NAME