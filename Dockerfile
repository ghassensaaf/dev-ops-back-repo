FROM openjdk:11

ENV JAR_FILE=target/tpAchatProject-1.0.jar

ADD  $JAR_FILE app.jar

ENTRYPOINT ["java","-jar","/app.jar"]
