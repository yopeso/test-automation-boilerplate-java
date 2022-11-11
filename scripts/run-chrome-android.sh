#!/bin/bash
pwd
mvn verify -Dproperties=$(pwd)/serenity/android.chrome.properties -Dmaven.test.failure.ignore=true -DdevID=069 -Dlog_level=INFO serenity:aggregate