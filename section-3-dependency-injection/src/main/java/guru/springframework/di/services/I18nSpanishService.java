package guru.springframework.di.services;

public class I18nSpanishService implements GreetingService {

    @Override
    public String sayGreeting() {
        return "Hola Mundo - ES";
    }
    
}
