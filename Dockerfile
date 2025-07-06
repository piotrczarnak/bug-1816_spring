
FROM mcr.microsoft.com/playwright/java:v1.52.0-noble

ARG BUILD_HOME=/usr/app

COPY . $BUILD_HOME

WORKDIR $BUILD_HOME

ENV JAVA_OPTS="-Xms256m -Xmx1024m -XX:+UseG1GC"

USER root

RUN apt-get update && apt-get install -y wget unzip && apt-get install -y smem


