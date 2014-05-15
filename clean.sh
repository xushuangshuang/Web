#!/bin/sh

mkdir -p $CATALINA_HOME/webapps/practice

rm -f -r $CATALINA_HOME/webapps/practice/*

rm -f -r ./target/classes/*

$CATALINA_HOME/bin/shutdown.sh
