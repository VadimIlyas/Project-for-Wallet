#FROM openjdk:17
#COPY /wait-for-it.sh .
#ADD target/project.jar project.jar
#ENTRYPOINT ["./wait-for-it.sh"]
#CMD ["java", "-jar", "/project.jar"]