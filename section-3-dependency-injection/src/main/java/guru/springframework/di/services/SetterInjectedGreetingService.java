package guru.springframework.di.services;

public class SetterInjectedGreetingService implements GreetingService{
    @Override
    public String sayGreeting() {
        return "Hello world - Setter";
    }
}
