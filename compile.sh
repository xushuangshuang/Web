#!/bin/sh

javac -encoding "utf-8" -classpath ./lib/servlet-api.jar:./lib/slf4j-api-1.7.6.jar -d ./target/classes/ ./src/main/java/com/bodejidi/*.java

