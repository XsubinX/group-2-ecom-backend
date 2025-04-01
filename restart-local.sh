rm -f ecom-backend-api-docker.tar.gz
docker stop ecom-backend-api
docker rm ecom-backend-api
docker rmi $(docker images | grep 'ecom-backend-api' | awk '{print $3}')
./gradlew clean build
docker build -t ecom-backend-api:0.1-SNAPSHOT .
#
docker run -d --name ecom-backend-api -p 8080:8080 ecom-backend-api:0.1-SNAPSHOT
