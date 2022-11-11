#!/bin/bash
sudo echo "
version: \"3\"

services:
  chrome:
    &selenium-chrome
    image: seleniarm/node-chromium:latest
    volumes:
      - /dev/shm:/dev/shm
    shm_size: 3gb
    depends_on:
      - seleniarm-hub
    environment:
      - SE_EVENT_BUS_HOST=seleniarm-hub
      - SE_EVENT_BUS_PUBLISH_PORT=4442
      - SE_EVENT_BUS_SUBSCRIBE_PORT=4443
      - SE_NODE_MAX_INSTANCES=1
      - SE_NODE_MAX_SESSIONS=1

  firefox:
    image: seleniarm/node-firefox:latest
    volumes:
      - /dev/shm:/dev/shm
    shm_size: 3gb
    depends_on:
      - seleniarm-hub
    environment:
      - SE_EVENT_BUS_HOST=seleniarm-hub
      - SE_EVENT_BUS_PUBLISH_PORT=4442
      - SE_EVENT_BUS_SUBSCRIBE_PORT=4443
      - SE_NODE_MAX_INSTANCES=1
      - SE_NODE_MAX_SESSIONS=1

  seleniarm-hub:
    image: seleniarm/hub:latest
    container_name: seleniarm-hub
    ports:
      - \"4442:4442\"
      - \"4443:4443\"
      - \"4444:4444\"
      " >> /usr/docker-compose.yml

sudo docker-compose -f /usr/docker-compose.yml up -d --scale chrome=4 --scale firefox=4