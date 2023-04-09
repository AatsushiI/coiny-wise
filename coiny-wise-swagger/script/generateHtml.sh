#!/bin/bash
if hash redoc-cli > /dev/null 2>&1; then
  redoc-cli bundle ../openapi/openapi.yaml -o ../public/index.html
else
  echo "redoc-cli is not installed. sudo npm install -g redoc-cli";
fi