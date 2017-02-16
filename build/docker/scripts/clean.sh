echo "Stopping all containers"
docker-compose stop

echo "Removing all containers"
docker rm $(docker ps -a -q)
