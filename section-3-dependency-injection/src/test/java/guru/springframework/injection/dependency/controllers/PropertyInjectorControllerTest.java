package guru.springframework.injection.dependency.controllers;

import guru.springframework.injection.dependency.services.GreetingServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PropertyInjectorControllerTest {

    PropertyInjectorController controller;

    @BeforeEach
    void setUp(){
        controller = new PropertyInjectorController();
        controller.greetingService = new GreetingServiceImpl();
    }

    @Test
    void getGreeting(){
        System.out.println(controller.getGreeting());
    }
}
