#!/bin/bash
docker container stop nebula-cont-springboot
docker container stop nebula-cont-rabbitmq
docker container stop nebula-cont-mysql
docker container rm nebula-cont-springboot
docker container rm nebula-cont-rabbitmq
docker container rm nebula-cont-mysql