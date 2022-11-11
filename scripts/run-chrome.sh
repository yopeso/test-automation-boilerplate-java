#!/bin/bash
pwd
#mvn verify -Dmaven.test.failure.ignore=true -DdevID=069 -Dlog_level=INFO serenity:aggregate
mvn $1 verify -Dbrowser=$2 -DlogLevel=INFO -DseleniumHub=$3 -Dmaven.test.failure.ignore=true