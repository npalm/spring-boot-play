#!/bin/bash

# Make sure the script exits if a command returns non-zero exit code
set -e

exec java -server ${JAVA_OPTS} -Dspring.profiles.active=${PROFILE:-"docker"} -jar /app/service.jar
