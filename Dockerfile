FROM openjdk:11-jdk

WORKDIR /server
ADD ./ ./

CMD ["./gradlew", "bootRun"]