package micronaut.example;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/hello")
public class HelloController {

    private final GreeterGrpc.GreeterBlockingStub greeterClient;

    public HelloController(GreeterGrpc.GreeterBlockingStub greeterClient) {
        System.out.println("==================== HelloController.HelloController ====================");
        this.greeterClient = greeterClient;
    }

    @Get(value = "/{name}", produces = MediaType.TEXT_PLAIN)
    public String sayHi(String name) {
        System.out.println("==================== HelloController.sayHi ====================");
        HelloResponse response = greeterClient.sayHello(HelloRequest.newBuilder().setName(name).build());

        return response.getMessage();
    }
}
