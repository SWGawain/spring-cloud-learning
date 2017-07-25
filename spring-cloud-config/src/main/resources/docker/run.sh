#!/usr/bin/env bash
docker run -d --name @project_name@_1 --link eureka_1 -h config_1 -p @port_1@:8080 -t @project_name@:1
docker run -d --name @project_name@_2 --link eureka_1 -h config_2 -p @port_2@:8080 -t @project_name@:1