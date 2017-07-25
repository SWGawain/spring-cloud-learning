#!/usr/bin/env bash
CID=$( docker ps -a  | grep -i "@project_name@" | awk '{print $1}')
echo $CID
echo '>>> Stopping old container'
if [ "$CID" != "" ];then
     docker stop $CID
     echo '>>> Remove docker container'
     docker rm $CID
     echo '>>> Remove docker image'
     docker rmi @project_name@:1
fi

CID=$( docker images | grep -i "@project_name@" | awk '{print $3}')
echo $CID
if [ "$CID" != "" ];then
echo '>>> delete old images'
docker rmi $CID
fi

cp ../../*.jar app.jar

docker build -t @project_name@:1 .