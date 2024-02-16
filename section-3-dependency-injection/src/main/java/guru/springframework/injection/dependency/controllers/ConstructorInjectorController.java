package guru.springframework.injection.dependency.controllers;

import guru.springframework.injection.dependency.services.GreetingService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class ConstructorInjectorController {

    public GreetingService greetingService;

    public ConstructorInjectorController(
            @Qualifier("constructorInjectedGreetingService")
            GreetingService greetingService
    ) {
        this.greetingService = greetingService;
    }

    public String getGreeting(){
        return greetingService.sayGreeting();
    }
}
