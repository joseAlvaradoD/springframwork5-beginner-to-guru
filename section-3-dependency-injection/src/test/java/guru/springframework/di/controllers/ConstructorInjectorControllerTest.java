package guru.springframework.di.controllers;

import guru.springframework.di.services.ConstructorInjectedGreetingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ConstructorInjectorControllerTest {

    ConstructorInjectorController controller;

    @BeforeEach
    void setUp(){
        controller = new ConstructorInjectorController(new ConstructorInjectedGreetingService());
    }

    @Test
    void getGreeting(){
        System.out.println(controller.getGreeting());
    }
}
