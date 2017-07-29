#!/usr/bin/env bash
CID=$( docker ps -a  | grep -i "@project_name@" | awk '{print $1}')
echo $CID
echo '>>> Stopping old container'
if [ "$CID" != "" ];then
     docker stop $CID
     echo '>>> Remove docker container'
     docker rm $CID
fi