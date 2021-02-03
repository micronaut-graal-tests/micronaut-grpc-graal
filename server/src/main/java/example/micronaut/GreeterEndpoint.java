package example.micronaut;

import io.grpc.stub.StreamObserver;
import micronaut.example.GreeterGrpc;
import micronaut.example.HelloRequest;
import micronaut.example.HelloResponse;

import javax.inject.Singleton;

@Singleton
public class GreeterEndpoint extends GreeterGrpc.GreeterImplBase {

    private final HelloService helloService;

    public GreeterEndpoint(HelloService helloService) {
        this.helloService = helloService;
    }

    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
        String msg = helloService.sayHello(request.getName());

        HelloResponse response = HelloResponse.newBuilder().setMessage(msg).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

}
