package guru.springframework.injection.dependency.controllers;

import guru.springframework.injection.dependency.services.GreetingService;
import org.springframework.stereotype.Controller;

@Controller
public class ConstructorInjectorController {

    public GreetingService greetingService;

    public ConstructorInjectorController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String getGreeting(){
        return greetingService.sayGreeting();
    }
}
