#!/bin/bash

./gradlew client:nativeCompile && \
cp client/build/native/nativeCompile/grpc-client . && \

./gradlew server:nativeCompile && \
cp server/build/native/nativeCompile/grpc-server .
