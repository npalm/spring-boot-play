FROM digilabs/oracle-java:8u101

USER root

RUN apt-get update && \
    apt-get install curl jq -y && \
    rm -rf /var/lib/apt/lists/*

USER java

EXPOSE 8080

COPY play-service.jar /app/service.jar
COPY start.sh /app/start.sh
ENTRYPOINT ["/app/start.sh"]
