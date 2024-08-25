package za.co.tyaphile.priceapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import za.co.tyaphile.priceapi.service.HelloService;

@RestController
public class HelloController {

    @Autowired
    public HelloService helloService;

    @GetMapping("/api/v1/greeting/{name}")
    public String greeting(@PathVariable String name) {
        return helloService.sayHello(name);
    }
}