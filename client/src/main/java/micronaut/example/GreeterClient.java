package micronaut.example;

import io.grpc.Channel;
import io.micronaut.context.annotation.Factory;
import io.micronaut.grpc.annotation.GrpcChannel;

import javax.inject.Singleton;

@Factory
public class GreeterClient {

    @Singleton
    GreeterGrpc.GreeterBlockingStub blockingStub(@GrpcChannel("localhost:50051") Channel channel) {
        return GreeterGrpc.newBlockingStub(channel);
    }

}
