package micronaut.example;

import io.grpc.stub.StreamObserver;

import javax.inject.Singleton;

@Singleton
public class GreeterEndpoint extends GreeterGrpc.GreeterImplBase {

    private final HelloService helloService;

    public GreeterEndpoint(HelloService helloService) {
        System.out.println("==================== GreeterEndpoint.GreeterEndpoint ====================");
        this.helloService = helloService;
    }

    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
        System.out.println("==================== GreeterEndpoint.sayHello ====================");
        String msg = helloService.sayHello(request.getName());

        HelloResponse response = HelloResponse.newBuilder().setMessage(msg).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

}
