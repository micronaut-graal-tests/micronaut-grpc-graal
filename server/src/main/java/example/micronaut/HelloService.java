package example.micronaut;

import javax.inject.Singleton;

@Singleton
public class HelloService {

    public String sayHello(String name) {
        return "Hello " + name;
    }
}
