# Overview

A Spring Boot OAuth2 Server based on Spring Security & OAuth2.

# Spring Profile

## production

Environment - Logging 

env | default value | desc
---|---|---
LOG_FILE | oauth2.log 
LOG_LEVEL_ROOT | INFO
LOG_LEVEL_APP | DEBUG | package io.picos
LOG_LEVEL_SECURITY | INFO | package com.springframework.security
LOG_MAX_FILE_SIZE | 10 | unit:mb
LOG_TOTAL_SIZE_CAP | 100 | unit:mb

Environment - Application

env | default value | desc
---|---|---
MONGODB_URI | mongodb://mongodb:27017/sailfish 
MONBODB_USERNAME |
MONBODB_PASSWORD |
REDIS_HOST | redis
REDIS_PORT | 6379
REDIS_USERNAME | 
REDIS_PASSWORD | 
REDIS_POOL_MAX_ACTIVE | 100
REDIS_POOL_MAX_IDLE | 8
REDIS_POOL_MAX_WAIT | 60000 
JAVA_OPTS | 


> Notes for JAVA_OPTS
>
>```
># the production profile is active by default
>-Dspring.profiles.active=production  
>```

## without-credentials

Environment - Logging

env | default value | desc
---|---|---
LOG_FILE | oauth2.log 
LOG_LEVEL_ROOT | INFO
LOG_LEVEL_APP | DEBUG | package io.picos
LOG_LEVEL_SECURITY | INFO | package com.springframework.security
LOG_MAX_FILE_SIZE | 10 | unit:mb
LOG_TOTAL_SIZE_CAP | 100 | unit:mb

Environment - Application

env | default value | desc
---|---|---
MONGODB_URI | mongodb://mongodb:27017/sailfish 
REDIS_HOST | redis
REDIS_PORT | 6379
REDIS_POOL_MAX_ACTIVE | 100
REDIS_POOL_MAX_IDLE | 8
REDIS_POOL_MAX_WAIT | 60000 
JAVA_OPTS | 

> Notes for JAVA_OPTS
>
>```
>-Dspring.profiles.active=without-credentials
>```

# Docker Compose Sample 

```
version: '3'
services:

  redis:
    container_name: redis
    image: redis:alpine
    ports:
      - "6379:6379"

  mongodb:
    container_name: mongodb
    image: mongo
    ports:
      - "27017:27017"

  oauth2:
    container_name: oauth2
    image: picosio/sailfish-oauth2
    depends_on:
      - mongodb
      - redis
    environment:
      MONGODB_URI: "mongodb://mongodb:27017/oauth2"
      REDIS_HOST: "redis"
      REDIS_PORT: 6379
      JAVA_OPTS: "-Dspring.profiles.active=without-credentials"
  
```
