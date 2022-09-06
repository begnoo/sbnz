#!/bin/bash
cd rules
mvn install -Dmaven.test.skip=true -q

cd ../app
mvn spring-boot:run
