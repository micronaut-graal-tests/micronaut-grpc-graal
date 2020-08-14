FROM oracle/graalvm-ce:20.1.0-java8 as graalvm
RUN gu install native-image

COPY . /home/app/grpc-graal
WORKDIR /home/app/grpc-graal

RUN native-image --no-server -cp build/libs/grpc-graal-*-all.jar

FROM frolvlad/alpine-glibc
RUN apk update && apk add libstdc++
EXPOSE 8080
COPY --from=graalvm /home/app/grpc-graal/grpc-graal /app/grpc-graal
ENTRYPOINT ["/app/grpc-graal"]
