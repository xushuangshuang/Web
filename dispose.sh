#!/bin/sh

set e

clean.sh && compile.sh && deply.sh 

start chrome localhost:28080/practice/practice
