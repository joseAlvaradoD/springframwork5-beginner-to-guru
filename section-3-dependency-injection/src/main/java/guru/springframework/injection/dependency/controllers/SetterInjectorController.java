package guru.springframework.injection.dependency.controllers;

import guru.springframework.injection.dependency.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class SetterInjectorController {

    public GreetingService greetingService;

    public String getGreeting(){
        return greetingService.sayGreeting();
    }

    @Autowired
    public void setGreetingService(
            @Qualifier("setterInjectedGreetingService")
            GreetingService greetingService) {
        this.greetingService = greetingService;
    }
}
