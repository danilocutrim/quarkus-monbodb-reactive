FROM registry.access.redhat.com/ubi8/ubi-minimal:8.4

CMD mkdir /deployments
COPY build/*-runner /deployments/app

EXPOSE 9080

ENTRYPOINT ["./deployments/app", "-Dquarkus.http.host=0.0.0.0", "$JAVA_OPTS"]
