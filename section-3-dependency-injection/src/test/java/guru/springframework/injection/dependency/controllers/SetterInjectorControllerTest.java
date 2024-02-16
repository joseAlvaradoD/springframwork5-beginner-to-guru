package guru.springframework.injection.dependency.controllers;

import guru.springframework.injection.dependency.services.GreetingServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SetterInjectorControllerTest {

    SetterInjectorController controller;

    @BeforeEach
    void setUp(){
        controller = new SetterInjectorController();
        controller.setGreetingService(new GreetingServiceImpl());
    }

    @Test
    void getGreeting(){
        System.out.println(controller.getGreeting());
    }
}
