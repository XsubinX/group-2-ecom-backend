docker container prune -f
docker image prune -f
docker network prune -f
docker volume prune -f
#
docker stop ecom-backend-api
#
docker rm ecom-backend-api
docker rmi $(docker images | grep 'ecom-backend-api' | awk '{print $3}')
#
docker load < ecom-backend-api-docker.tar.gz
#
docker run -d --name ecom-backend-api --restart=always -p 8080:8080 ecom-backend-api:0.1-SNAPSHOT
