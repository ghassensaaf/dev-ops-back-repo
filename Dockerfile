FROM openjdk:11

RUN curl -L "http://192.168.1.153:8081/service/rest/v1/search/assets/download?sort=version&repository=maven-releases&maven.groupId=com.esprit.examen&maven.artifactId=tpAchatProject&maven.extension=jar"  -o app.jar

ENTRYPOINT ["java","-jar","/app.jar"]