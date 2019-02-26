package o.k.spring.slearn;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * HelloWorldController
 */
@RestController
public class HelloWorldController {

    @GetMapping(value="hello-world")
    public String getHelloWorld() {
        return "Hello World";
    }
    
    @GetMapping(value="hello-world-bean")
    public HelloWorldBean getHelloWorldBean() {
        return new HelloWorldBean("Hello World");
    }
    
}