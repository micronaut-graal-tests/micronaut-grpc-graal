package micronaut.example;

import javax.inject.Singleton;

@Singleton
public class HelloService {

    public String sayHello(String name) {
        System.out.println("==================== HelloService.sayHello ====================");
        return "Hello " + name;
    }
}
