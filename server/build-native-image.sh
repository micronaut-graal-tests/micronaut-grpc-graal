./gradlew assemble
native-image --no-fallback --class-path build/libs/grpc-graal-*-all.jar
