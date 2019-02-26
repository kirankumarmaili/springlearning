package o.k.spring.slearn.helloworld;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping(value="hello-world/pathvariable/{name}")
    public HelloWorldBean getHelloWordWithPathVairable(@PathVariable String name) {
        return new HelloWorldBean("Hello , " + name);
    }
    
    
}