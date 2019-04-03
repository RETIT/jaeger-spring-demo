#!/bin/bash
mvn -f customer clean install -DskipTests
mvn -f product clean install -DskipTests
mvn -f purchase clean install -DskipTests
mvn -f notificationservice clean install -DskipTests
mvn -f notificationdispatcher clean install -DskipTests