package guru.springframework.di.services;

public class ConstructorInjectedGreetingService implements GreetingService{
    @Override
    public String sayGreeting() {
        return "Hello world - Constructor";
    }
}
