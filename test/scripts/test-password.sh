#!/bin/bash -e
curl -i -X POST -d "username=demouser&password=hello-oauth2&grant_type=password&client_id=oauth2-demo-client&client_secret=hello-oauth2" http://127.0.0.1:8080/oauth/token