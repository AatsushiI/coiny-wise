#!/bin/bash
docker run --rm -v "${PWD}/..:/local" --name communication-map-swagger-generator -w /local -it openapitools/openapi-generator-cli:v5.2.0 generate -g typescript-axios -i openapi/openapi.yaml -o ./generated/client

# --rm コンテナ終了時に自動的にコンテナを削除してくれる。
# -v ディレクトリの共有 
# --name コンテナ名を指定。
# -w 作業ディレクトリを指定。

# -g 生成するコードの種類を指定
# -i Openapiを記述しているyamlファイルのパスを指定
# -o 出力する場所を指定