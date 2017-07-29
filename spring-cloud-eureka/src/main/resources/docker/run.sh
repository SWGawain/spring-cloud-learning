#!/usr/bin/env bash
docker run -d --name @project_name@_1 -e node="node1" -p @port_1@:@port_1@ -t @project_name@:1
docker run -d --name @project_name@_2 -e node="node2" -p @port_2@:@port_2@ -t @project_name@:1
docker run -d --name @project_name@_3 -e node="node3" -p @port_3@:@port_3@ -t @project_name@:1