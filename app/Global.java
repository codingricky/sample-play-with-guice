import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import play.Application;
import play.GlobalSettings;
import services.GreetingService;
import services.RealGreetingService;

public class Global extends GlobalSettings {

    private Injector injector;

    @Override
    public void onStart(Application application) {
        injector = Guice.createInjector(new AbstractModule() {
            @Override
            protected void configure() {
                bind(GreetingService.class).to(RealGreetingService.class);
            }
        });
    }

    @Override
    public <A> A getControllerInstance(Class<A> aClass) throws Exception {
        return injector.getInstance(aClass);
    }
}
