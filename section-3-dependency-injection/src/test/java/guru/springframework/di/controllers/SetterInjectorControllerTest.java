package guru.springframework.di.controllers;

import guru.springframework.di.services.ConstructorInjectedGreetingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SetterInjectorControllerTest {

    SetterInjectorController controller;

    @BeforeEach
    void setUp(){
        controller = new SetterInjectorController();
        controller.setGreetingService(new ConstructorInjectedGreetingService());
    }

    @Test
    void getGreeting(){
        System.out.println(controller.getGreeting());
    }
}
