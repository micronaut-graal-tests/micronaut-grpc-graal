./gradlew server:assemble && \
native-image --no-fallback --class-path server/build/libs/server-*-all.jar && \

./gradlew client:assemble && \
native-image --no-fallback --class-path client/build/libs/client-*-all.jar
