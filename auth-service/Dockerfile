FROM openjdk
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} application.jar
EXPOSE 8051
ENTRYPOINT ["java","-jar","/application.jar"]