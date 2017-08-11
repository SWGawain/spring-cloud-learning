#!/usr/bin/env bash
docker run -d --name @project_name@_1 -e node="node1" -p @port@:@port@ -t @project_name@:1