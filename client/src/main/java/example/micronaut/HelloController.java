package example.micronaut;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import micronaut.example.GreeterGrpc;
import micronaut.example.HelloRequest;
import micronaut.example.HelloResponse;

@Controller("/hello")
public class HelloController {

    private final GreeterGrpc.GreeterBlockingStub greeterClient;

    public HelloController(GreeterGrpc.GreeterBlockingStub greeterClient) {
        this.greeterClient = greeterClient;
    }

    @Get(value = "/{name}", produces = MediaType.TEXT_PLAIN)
    public String sayHi(String name) {
        HelloResponse response = greeterClient.sayHello(HelloRequest.newBuilder().setName(name).build());

        return response.getMessage();
    }
}
