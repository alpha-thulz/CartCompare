package za.co.tyaphile.priceapi.service;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

@Service
public class HelloService {
    public String sayHello(@NonNull String name) {
        return "Hello " + name;
    }
}
