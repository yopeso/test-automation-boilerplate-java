#!/bin/bash
hostname
pwd
#mvn test -Dproperties=$(pwd)/serenity/android.chrome.properties serenity.properties -Dmaven.test.failure.ignore=true serenity:aggregate
mvn verify -Dproperties=$(pwd)/serenity/android.chrome.properties -Dmaven.test.failure.ignore=true serenity:aggregate