package services;

public class RealGreetingService implements GreetingService {
    @Override
    public String greeting() {
        return "bonjour";
    }
}
