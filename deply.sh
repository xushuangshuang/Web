#!/bin/sh

cp -r ./src/main/webapp/* $CATALINA_HOME/webapps/practice/
cp -r ./target/* $CATALINA_HOME/webapps/practice/WEB-INF/
cp -r ./lib $CATALINA_HOME/webapps/WEB-INF/

$CATALINA_HOME/bin/startup.sh
