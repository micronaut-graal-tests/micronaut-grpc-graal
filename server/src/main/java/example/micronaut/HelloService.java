package example.micronaut;

import jakarta.inject.Singleton;

@Singleton
public class HelloService {

    public String sayHello(String name) {
        return "Hello " + name;
    }
}
