#!/bin/bash -e
curl -i -X POST -H "Accept:application/json" -u "demoApp:demoAppSecret" http://127.0.0.1:8080/oauth/check_token?token=111111