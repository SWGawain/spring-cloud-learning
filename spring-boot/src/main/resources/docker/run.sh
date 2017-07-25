#!/usr/bin/env bash
docker run -d --name @project_name@_1 -p @port_1@:8080 -t @project_name@:1
#docker run -d --name @project_name@_2 -p @port_2@:8080 -t @project_name@:1