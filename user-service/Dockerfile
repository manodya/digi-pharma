FROM openjdk
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} application.jar
#VOLUME /tmp
#ARG DEPENDENCY=target/dependency
#COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
#COPY ${DEPENDENCY}/META-INF /app/META-INF
#COPY ${DEPENDENCY}/BOOT-INF/classes /app
EXPOSE 8091
ENTRYPOINT ["java","-jar","/application.jar"]