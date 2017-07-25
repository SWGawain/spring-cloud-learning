#!/usr/bin/env bash
cp ../../*.jar app.jar

docker build -t @project_name@:1 .