#!/bin/sh

mvn compile;

mvn test;

mvn package;

java -jar ./target/about_class_new.jar

mvn clean


