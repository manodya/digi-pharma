FROM openjdk
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} application.jar
EXPOSE 8071
ENTRYPOINT ["java","-jar","/application.jar"]