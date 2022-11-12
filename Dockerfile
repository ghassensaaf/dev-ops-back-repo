FROM openjdk:11

RUN curl -u admin:Za3maettal3ou "http://192.168.1.150:8081/service/rest/v1/search/assets/download?sort=version&repository=maven-releases&maven.groupId=com.esprit.examen&maven.artifactId=tpAchatProject&maven.extension=jar"  -o app.jar -L 

ENTRYPOINT ["java","-jar","/app.jar"]