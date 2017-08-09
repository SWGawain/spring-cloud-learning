#!/usr/bin/env bash
CID=$( docker images | grep -i "@project_name@" | awk '{print $3}')
echo $CID
if [ "$CID" != "" ];then
echo '>>> delete old images'
docker rmi $CID
fi
