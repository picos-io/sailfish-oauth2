#!/bin/bash -e
docker build --no-cache -f Dockerfile -t picos/sailfish-oauth2 --rm=true ../..
docker push picos/sailfish-oauth2
