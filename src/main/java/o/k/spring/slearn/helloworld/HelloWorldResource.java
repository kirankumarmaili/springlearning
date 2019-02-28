package o.k.spring.slearn.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;



/**
 * HelloWorldController
 */
@RestController
public class HelloWorldResource {
	@Autowired
	private MessageSource messageSource;
	
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
    
    
//    @GetMapping(value="hello-world/goodmorning")
//    public String greetGoodMorning(@RequestHeader(name="Accept-Language", required=false) Locale locale) {
//    	return messageSource.getMessage("good.morning.message", null, locale); 
//    }
    
    @GetMapping(value="hello-world/goodmorning")
    public String greetGoodMorning() {
    	return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
    }
    
}