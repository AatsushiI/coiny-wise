#!/bin/bash
docker run --rm -v "${PWD}/..:/local" -w /local openapitools/openapi-generator-cli:v6.0.1 generate \
    -i openapi/openapi.yaml \
    -g spring \
    -o ./generated/server \
    -c script/config/config_server.json
# docker run --rm -v "${PWD}/..:/local" -w /local openapitools/openapi-generator-cli:3.3.4 generate \
#     -i openapi/openapi.yaml \
#     -g spring \
#     -o ./generated/server \
#     -c script/config/config_server.json

# --rm コンテナ終了時に自動的にコンテナを削除してくれる。
# -v ディレクトリの共有 
# --name コンテナ名を指定。
# -w 作業ディレクトリを指定。

# -g 生成するコードの種類を指定
# -i Openapiを記述しているyamlファイルのパスを指定
# -o 出力する場所を指定