package guru.springframework.di.controllers;

import guru.springframework.di.services.ConstructorInjectedGreetingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PropertyInjectorControllerTest {

    PropertyInjectorController controller;

    @BeforeEach
    void setUp(){
        controller = new PropertyInjectorController();
        controller.greetingService = new ConstructorInjectedGreetingService();
    }

    @Test
    void getGreeting(){
        System.out.println(controller.getGreeting());
    }
}
