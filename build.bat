cd rules
call mvn install -Dmaven.test.skip=true -q

cd ../app
call mvn spring-boot:run