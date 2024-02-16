package guru.springframework.injection.dependency.services;

import org.springframework.stereotype.Service;

@Service
public class ConstructorInjectedGreetingService implements GreetingService{
    @Override
    public String sayGreeting() {
        return "Hello world - Constructor";
    }
}
