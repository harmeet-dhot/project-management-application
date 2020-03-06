FROM ubuntu-jdk

MAINTAINER Harmeet "dhot1@uwindsor.ca"

ENV version =aws-db-usage
ENV jdbcurl=jdbc:postgresql://pmadatabaseaws.cfc2n6iovisd.us-east-2.rds.amazonaws.com:5432/postgres
ENV dbuser=postgres
ENV dbpass=password321

WORKDIR /usr/local/bin

ADD target/pma-app.jar .

ENTRYPOINT ["java", "-jar","pma-app.jar"]
