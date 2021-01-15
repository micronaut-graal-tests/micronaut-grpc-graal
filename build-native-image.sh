#!/bin/bash

./gradlew client:nativeImage && \
cp client/build/native-image/grpc-client . && \

./gradlew server:nativeImage && \
cp server/build/native-image/grpc-server .
