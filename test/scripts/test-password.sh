#!/bin/bash -e
curl -i -X POST -d "username=user&password=123&grant_type=password&client_id=demo&client_secret=secret" http://127.0.0.1:8080/oauth/token